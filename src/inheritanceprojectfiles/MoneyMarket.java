package inheritanceprojectfiles;

public class MoneyMarket extends Savings{

    private int withdrawal; //number of withdrawls
    private static final double INTEREST_RATE = 4.5;

    public MoneyMarket(){

    }

    public MoneyMarket(Profile holder, double balance, int withdrawal) {
        super(holder, balance, true);
        this.withdrawal = withdrawal;
    }

    public int getWithdrawal() {
        return withdrawal;
    }

    public void setWithdrawal(int withdrawal) {
        this.withdrawal = withdrawal;
    }

    @Override
    public double monthlyInterest() {
        if(isLoyal){
            double interestRate = INTEREST_RATE+0.25;
            return (balance*(interestRate/100))/12;
        }
        else{
            return (balance*(INTEREST_RATE/100))/12;
        }
    }

    @Override
    public double monthlyFee() {
        if(balance>=2000){
            return 0;
        }
        else{
            return Savings.MONTHLY_FEE;
        }
    }
    @Override
    public int compareTo(Account account) {
        if(account instanceof MoneyMarket){
            return super.compareTo(account);
        }
        else {
            return this.getClass().getName().compareTo(account.getClass().getName());
        }
    }

    @Override
    public String toString() {
        if (isLoyal)
            return "Money Market:: " + super.getClass().getName() + " ::" + holder.toString() + ":: Balance " + String.format("$%,.2f", balance) + ":: is loyal:: withdrawal:" + withdrawal;
        else
            return "Money Market:: " + super.getClass().getName() + " ::" + holder.toString() + ":: Balance " + String.format("$%,.2f", balance) + ":: withdrawal:" + withdrawal;
    }

    @Override
    public boolean equals(Account account) {
        if (account instanceof MoneyMarket) {
            return super.equals(account);
        } else return false;
    }
}
