package al.edu.fti.utils;

public class CourseStudent {

    private Long idCourse;
    private Long idStudent;

    public Long getIdCourse() {
        return idCourse;
    }

    public void setIdCourse(Long idCourse) {
        this.idCourse = idCourse;
    }

    public Long getIdStudent() {
        return idStudent;
    }

    public void setIdStudent(Long idStudent) {
        this.idStudent = idStudent;
    }

    public CourseStudent() {
    }

    public CourseStudent(Long idCourse, Long idStudent) {
        this.idCourse = idCourse;
        this.idStudent = idStudent;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CourseStudent that = (CourseStudent) o;

        if (idCourse != null ? !idCourse.equals(that.idCourse) : that.idCourse != null) return false;
        return idStudent != null ? idStudent.equals(that.idStudent) : that.idStudent == null;
    }

    @Override
    public int hashCode() {
        int result = idCourse != null ? idCourse.hashCode() : 0;
        result = 31 * result + (idStudent != null ? idStudent.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "CourseStudent{" +
                "idCourse=" + idCourse +
                ", idStudent=" + idStudent +
                '}';
    }
}
