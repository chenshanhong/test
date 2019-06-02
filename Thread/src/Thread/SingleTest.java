package Thread;

public class SingleTest {

	public static void main(String[] args) {
		Student st=Student.getStudent();
		Student st2=Student.getStudent();
		st.setAge(18);
		st2.setName("zhangsan");
		System.out.println(st.getName());
		System.out.println(st2.getAge());

	}

}
class Student {
	private String name;
	private int age;
	public String getName() {
		return name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public void setName(String name) {
		this.name = name;
	}
	private Student() {}
	static Student s=new Student();
	public static Student getStudent() {
		return s;
		
	}
}