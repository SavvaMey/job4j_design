package srp.generatorreports;

public class ConvertToDollars implements Convert {

    @Override
    public double convert(double salary) {

        return salary / 70;
    }
}
