import dtos.District;
import dtos.House;
import generation.dtogenerator.Faker;

public class Main {
    public static void main(String[] args) {
        Faker<House> faker = new Faker<>();
        House house = faker.create(House.class);
        System.out.println(house);
        Faker<District> faker2 = new Faker<>();
        District district = faker2.create(District.class);
        System.out.println(district);

        System.out.println("done");
    }
}
