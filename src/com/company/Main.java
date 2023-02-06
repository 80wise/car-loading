package com.company;

public class Main {

    public static void main(String[] args) {

        IOrder milk = new Goods("Milk", GoodsTypes.liquid, 10, 20);
        IOrder bred = new Goods("Bred", GoodsTypes.comestible, 10, 10);
        IOrder garbage = new Goods("garbage", GoodsTypes.perishable, 20, 40);
        IOrder tourists = new Passengers(10);
        IOrder students = new Passengers(30);

        Order<IOrder> orderOfMilk = new Order<>(milk, "factory", "super market", 9,
                "best milk of the country");
        Order<IOrder> orderOfBred = new Order<>(bred, "bakery", "super market", 4,
                "best bred of the region");
        Order<IOrder> orderOfGarbageCollector = new Order<>(garbage, "building", "Sea", 2,
                "throwing of garbage");
        Order<IOrder> orderOfTourists = new Order<>(tourists, "train station", "airport", 1,
                "tourists from spain");
        Order<IOrder> orderOfStudents = new Order<>(students, "University", "Hostel", 5,
                "Students of technical university");

        ITransport taxi = new PassengerTrans(2010, "BMW", "610", State.repaired, "essence",
                1, 4, 10, 5, 1);
        if (loadOrder(taxi, orderOfStudents)) {
            System.out.println("The order of students has been taken");
            outputInformation(taxi);
        } else {
            System.out.println("The students order can not be taken by the taxi driver because of number of people ");
        }

        Body box = new Body( 100, 500,80, 10, BodyType.box,
                GoodsTypes.perishable, GoodsTypes.manufactured,GoodsTypes.comestible, GoodsTypes.inflammatory);
        ITransport truck = new CargoTrans(1999, "Tata", "qwerty", State.repairProcess,
                "gaz", 3, 20, 50, box);
        if (loadOrder(truck, orderOfBred)) {
            System.out.println("The order of bred has been taken by the truck");
            outputInformation(truck);
        } else {
            System.out.println("The bred order can not be taken because of the time of this product or the volume ");
        }

        ITransport bus = new PassengerTrans(2022, "Mazda", "207", State.repaired,
                "essence", 2, 5, 30, 40,
                0);

        Body refrigerator = new Body(100, 70, 10, 10, BodyType.refrigerated,
                GoodsTypes.liquid, GoodsTypes.comestible);
        ITransport cargo = new CargoTrans(1999, "tata", "A40", State.broken,
                "gaz", 3, 10, 40,refrigerator);
        ITransport hybrid = new CargoPassengerTrans((IPassengerTrans) bus, (ICargoTrans) cargo);

        if (loadOrder(hybrid, orderOfMilk) && loadOrder(hybrid, orderOfBred)
                && loadOrder(hybrid, orderOfStudents) && loadOrder(hybrid, orderOfTourists)) {
            System.out.println("All the orders have been loaded in both parts of our hybrid transport");
            outputInformation(hybrid);
        } else {
            System.out.println("the orders have not been loaded because of some different raisons");
        }

        if(unloadOrder(hybrid, orderOfMilk) && unloadOrder(hybrid,orderOfTourists)){
            System.out.println("The orders of milk and bred have been unloaded(delivered) to the shop");
            System.out.println("Information about the remaining orders in our hybrid car:");
            outputInformation(hybrid);
        }else {
            System.out.println("The orders of milk and tourist can not be unload");
        }

        if(loadOrder(hybrid, orderOfGarbageCollector)){
            System.out.println("The garbage has been loaded in the hybrid car");
            outputInformation(hybrid);
        }else{
            System.out.println("The order of garbage collector can not be loaded because of the type of goods");
        }
    }

    public static Boolean loadOrder(ITransport transport, Order<?> order) {
        if (transport instanceof Transport) {
            if (((Transport<?>) transport).getOrders().isPresent())
                if (transport instanceof PassengerTrans && order.getLoadedOrder() instanceof Passengers) {
                    return ((PassengerTrans) transport).addOrder((Order<Passengers>) order);
                } else if (transport instanceof CargoTrans && order.getLoadedOrder() instanceof Goods) {
                    return ((CargoTrans) transport).addOrder((Order<Goods>) order);
                }
        } else if (transport instanceof CargoPassengerTrans) {
            if (((CargoPassengerTrans) transport).getPassengerPart() instanceof PassengerTrans
                    && ((PassengerTrans) ((CargoPassengerTrans) transport).getPassengerPart()).getOrders().isPresent()
                    && order.getLoadedOrder() instanceof Passengers) {

                return ((PassengerTrans) ((CargoPassengerTrans) transport).getPassengerPart()).addOrder((Order<Passengers>) order);

            } else if (((CargoPassengerTrans) transport).getCargoPart() instanceof CargoTrans
                    && ((CargoTrans) ((CargoPassengerTrans) transport).getCargoPart()).getOrders().isPresent()
                    && order.getLoadedOrder() instanceof Goods) {

                return ((CargoTrans) ((CargoPassengerTrans) transport).getCargoPart()).addOrder((Order<Goods>) order);

            }
        }
        return false;
    }

    public static Boolean unloadOrder(ITransport transport, Order<?> order) {
        if (transport instanceof Transport) {
            if (((Transport<?>) transport).getOrders().isPresent())
                if (transport instanceof PassengerTrans && order.getLoadedOrder() instanceof Passengers) {
                    return ((PassengerTrans) transport).removeOrder((Order<Passengers>) order);
                } else if (transport instanceof CargoTrans && order.getLoadedOrder() instanceof Goods) {
                    return ((CargoTrans) transport).removeOrder((Order<Goods>) order);
                }
        } else if (transport instanceof CargoPassengerTrans) {
            if (((CargoPassengerTrans) transport).getPassengerPart() instanceof PassengerTrans
                    && ((PassengerTrans) ((CargoPassengerTrans) transport).getPassengerPart()).getOrders().isPresent()
                    && order.getLoadedOrder() instanceof Passengers) {

                return ((PassengerTrans) ((CargoPassengerTrans) transport).getPassengerPart())
                        .removeOrder((Order<Passengers>) order);
            } else if (((CargoPassengerTrans) transport).getCargoPart() instanceof CargoTrans
                    && ((CargoTrans) ((CargoPassengerTrans) transport).getCargoPart()).getOrders().isPresent()
                    && order.getLoadedOrder() instanceof Goods) {

                return ((CargoTrans) ((CargoPassengerTrans) transport).getCargoPart())
                        .removeOrder((Order<Goods>) order);
            }
        }
        return false;
    }

    public static void outputInformation(ITransport transport) {
        System.out.println(transport.getInformationOfThisTransport());
    }
}
