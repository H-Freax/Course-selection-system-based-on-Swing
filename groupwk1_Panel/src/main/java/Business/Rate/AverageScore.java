package Business.Rate;

public class AverageScore {
    private double avgScorePart1;
    private double avgScorePart2;
    private double avgScorePart3;
    private double avgScorePart4;
    private double avgScore;

    public AverageScore(double avgScorePart1, double avgScorePart2, double avgScorePart3, double avgScorePart4, double avgScore) {
        this.avgScorePart1 = avgScorePart1;
        this.avgScorePart2 = avgScorePart2;
        this.avgScorePart3 = avgScorePart3;
        this.avgScorePart4 = avgScorePart4;
        this.avgScore = avgScore;
    }

    public double getAvgScorePart1() {
        return avgScorePart1;
    }

    public double getAvgScorePart2() {
        return avgScorePart2;
    }

    public double getAvgScorePart3() {
        return avgScorePart3;
    }

    public double getAvgScorePart4() {
        return avgScorePart4;
    }

    public double getAvgScore() {
        return avgScore;
    }
}
