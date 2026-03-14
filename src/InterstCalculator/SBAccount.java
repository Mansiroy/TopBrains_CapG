package InterstCalculator;

class SBAccount extends Account {

    String type; // Normal or NRI

    public SBAccount(double amount, String type) throws InvalidInputException {
        if (amount < 0) {
            throw new InvalidInputException("Invalid Amount");
        }
        this.amount = amount;
        this.type = type;
    }

    @Override
    double calculateInterest() {
        if (type.equalsIgnoreCase("Normal")) {
            interestRate = 4;
        } else if (type.equalsIgnoreCase("NRI")) {
            interestRate = 6;
        }

        return (amount * interestRate) / 100;
    }
}