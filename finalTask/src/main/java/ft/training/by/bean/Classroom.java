package ft.training.by.bean;

import ft.training.by.bean.enums.ClassroomType;

import java.util.Objects;

public class Classroom extends Entity {
    private String number;
    private int capacity;
    private ClassroomType classroomType;
    private boolean hasProjector;

    public Classroom() {
    }

    public Classroom(int id) {
        super(id);
    }

    public Classroom(int id, String number, int capacity, ClassroomType classroomType, boolean hasProjector) {
        super(id);
        this.number = number;
        this.capacity = capacity;
        this.classroomType = classroomType;
        this.hasProjector = hasProjector;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public ClassroomType getClassroomType() {
        return classroomType;
    }

    public void setClassroomType(ClassroomType classroomType) {
        this.classroomType = classroomType;
    }

    public boolean isHasProjector() {
        return hasProjector;
    }

    public void setHasProjector(boolean hasProjector) {
        this.hasProjector = hasProjector;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Classroom classroom = (Classroom) o;
        return capacity == classroom.capacity &&
                hasProjector == classroom.hasProjector &&
                number.equals(classroom.number) &&
                classroomType == classroom.classroomType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), number, capacity, classroomType, hasProjector);
    }

    @Override
    public String toString() {
        return "Classroom{" +
                "id='" + getId() + '\'' +
                ", number='" + number + '\'' +
                ", capacity=" + capacity +
                ", type=" + classroomType +
                ", hasProjector=" + hasProjector +
                '}';
    }
}
