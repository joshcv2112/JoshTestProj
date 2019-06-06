public class TestCaseData {

    private String entryTime;
    private String entryDate;
    private boolean entryTimeIsAM;
    private String exitTime;
    private String exitDate;
    private boolean exitTimeIsAM;
    private String cost;

    public TestCaseData(String[] data) {
        this.entryTime = data[0];
        this.entryDate = data[1];
        this.entryTimeIsAM = Boolean.valueOf(data[2]);
        this.exitTime = data[3];
        this.exitDate = data[4];
        this.exitTimeIsAM = Boolean.valueOf(data[5]);
        this.cost = data[6];
    }

    public String getEntryTime() {
        return entryTime;
    }

    public String getEntryDate() {
        return entryDate;
    }

    public boolean isEntryTimeIsAM() {
        return entryTimeIsAM;
    }

    public String getExitTime() {
        return exitTime;
    }

    public String getExitDate() {
        return exitDate;
    }

    public boolean isExitTimeIsAM() {
        return exitTimeIsAM;
    }

    public String getCost() {
        return cost;
    }
}
