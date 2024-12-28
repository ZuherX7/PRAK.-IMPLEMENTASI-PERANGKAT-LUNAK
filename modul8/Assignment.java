public class Assignment {
    private double mark=-1;
        Assignment(){ }
    public double getMark() throws NotYetSetException {
        if (mark==-1) {
            throw new
            NotYetSetException("Nilai belum diatur");
        }
        return mark;
    }

    public void setMark( int m) {
        mark=m;
    }
}