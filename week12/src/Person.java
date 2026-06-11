public class Person {

    private String name;
    private String gender;

    public String getGender() {
        return gender;
    }

    public Person(String name, String gender) {
        this.name = name;
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public void writeExcel(Stirng fileName, ArrayList<Student> students) {
        record(workboo, sheet, students);

        try {
            OutputStream outputStream = new FileOutputStream(fileName);
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(outputStream);

            //flush() : 버퍼에 있는 데이터를 출력 스트림으로 내보내는 메서드 > 버퍼가 다 안찼더라도 flush로 마무리 처리

        }
    }
}
