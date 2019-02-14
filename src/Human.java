public class Human {
    // Thuộc tính của class
    public String name;
    public int age;
    public String phone;

    // Hàm tạo để tạo đối tượng
    public Human() {
        this.name = "No Name";
        this.age = 10;
        this.phone = "0123456789";
    }

    public Human(String name, int age, String phone) {
        this.name = name;
        this.age = age;
        this.phone = phone;
    }

    // phương thức (method)
    public void eat() {
        System.out.println("Eating ...");
    }
    public void sleep(int duration) {
        System.out.println("Sleeping in " + duration + " hours ...");
    }
}
