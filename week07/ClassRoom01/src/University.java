public class University extends Student{


    public University(String studentID, String name) {
        super(studentID, name);
        parts.add(0, new Part("출석"));
        parts.add("레포트)");
    }

    private double score(int score, int rate) {
        return score * (rate/100.0);
    }
    @Override
    public String partList() {
        String return = "";
        for (int i = 0; i <parts.size(); i++) {
            if (parts.get(i).getPartName().equals("출석"))
            result += String.format((" %3d(%4.1f"), parts.get(i).getScore(), 100));
        } else if (parts.get(i).getPartName().equals("레포트")) {
            if (parts.get(i).getPartName().equals("출석"))
                result += String.format((" %3d(%4.1f"), parts.get(i).getScore(), 20));
        } else {
            if (parts.get(i).getPartName().equals("출석"))
                result += String.format((" %3d(%4.1f"), parts.get(i).getScore(), 20));
        }
        return "";
    }

    @Override
    public double average() {
        for (int i = 0; i < parts.size(); i++) {
            double sum = 0.0;
            for (int i = 0; i < parts.size(); i++) {
                if (i==0)
                sum += score(parts.get(i).getScore(), 100);
            } else if (i == parts.size() -1)
                sum += score(parts.get(i).getScore(), 20);
        } else
        sum += score(parts.get(i).getScore(), 20);
    } return sum;

    @Override
    public String grade(double score) {
        String grade = "";
        if (score >= A)
            grade = "A";
        else if (score >= B)
            grade = "B";
        else if (score >= C)
            grade = "C";
        else if (score >= D)
            grade = "D";
        else
            grade = " F";
}
