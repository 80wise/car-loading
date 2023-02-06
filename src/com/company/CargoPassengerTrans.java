package com.company;

public class CargoPassengerTrans implements ICargoTrans, IPassengerTrans, ITransport {
    private IPassengerTrans passengerPart;
    private ICargoTrans cargoPart;

    public CargoPassengerTrans(IPassengerTrans passengerPart, ICargoTrans cargoPart) {
        this.passengerPart = passengerPart;
        this.cargoPart = cargoPart;
    }

    public CargoPassengerTrans() {
    }

    public IPassengerTrans getPassengerPart() {
        return passengerPart;
    }

    public void setPassengerPart(IPassengerTrans passengerPart) {
        this.passengerPart = passengerPart;
    }

    public ICargoTrans getCargoPart() {
        return cargoPart;
    }

    public void setCargoPart(ICargoTrans cargoPart) {
        this.cargoPart = cargoPart;
    }

    @Override
    public void seal() {
        if (cargoPart instanceof CargoTrans)
            ((CargoTrans) cargoPart).seal();
    }

    @Override
    public void disinfect() {
        if (passengerPart instanceof PassengerTrans)
            ((PassengerTrans) passengerPart).disinfect();
    }

    @Override
    public StringBuilder getInformationOfThisTransport() {
        StringBuilder info =new StringBuilder("Information of the passenger part\n");
        if (passengerPart != null && passengerPart instanceof PassengerTrans)
            info.append(((PassengerTrans) passengerPart).getInformationOfThisTransport());

        info.append("\nInformation of the cargo part\n");

        if (cargoPart != null && cargoPart instanceof CargoTrans)
            info.append(((CargoTrans) cargoPart).getInformationOfThisTransport());
        return info;
    }
}
