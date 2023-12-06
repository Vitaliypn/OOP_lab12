package task1;

public class Tray {
    private int denomination;
    private Tray next;
    private int count;

    public Tray(int denomination) {
        this.denomination = denomination;
        this.count = 0;
    }

    public Tray setNext(Tray tray) {
        this.next = tray;
        return this;
    }

    public void process(int amount) {
        int dispensedCount = amount / denomination;
        int remainingAmount = amount % denomination;

        if (next != null) {
            next.process(remainingAmount);
        } else if (remainingAmount > 0) {
            throw new IllegalArgumentException("Cannot dispense the requested amount");
        }

        count += dispensedCount;
        System.out.println("You should take " + dispensedCount + " of denomination " + denomination);
    }

    public int getDenominationCount(int denominationToGet) {
        if (denominationToGet == denomination) {
            return count;
        } else if (next != null) {
            return next.getDenominationCount(denominationToGet);
        } else {
            throw new IllegalArgumentException("Denomination not found in the tray chain");
        }
    }
}
