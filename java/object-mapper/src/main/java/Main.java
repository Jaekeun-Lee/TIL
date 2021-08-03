import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import dto.Car;
import dto.User;

import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) throws JsonProcessingException {
        System.out.println("hi");

        ObjectMapper objectMapper = new ObjectMapper();

        User user = new User();
        user.setName("홍길동");
        user.setAge(25);

        Car firstCar = new Car();
        firstCar.setName("K5");
        firstCar.setCarNumber("111가 1111");
        firstCar.setType("sedan");

        Car secondCar = new Car();
        secondCar.setName("QM6");
        secondCar.setCarNumber("222가 2222");
        secondCar.setType("SUV");

        List<Car> carList = Arrays.asList(firstCar, secondCar);
        user.setCars(carList);

        System.out.println(user);


        String jsonObject = objectMapper.writeValueAsString(user);
        System.out.println(jsonObject);

        JsonNode jsonNode = objectMapper.readTree(jsonObject);
        String _name = jsonNode.get("name").asText();
        int _age = jsonNode.get("age").asInt();

        // 배열 형태도 새로운 노드
        JsonNode cars = jsonNode.get("cars");
        ArrayNode arrayNode = (ArrayNode) cars;

        List<Car> _cars = objectMapper.convertValue(arrayNode, new TypeReference<List<Car>>() {
        });

        System.out.println("name : " + _name);
        System.out.println("age : " + _age);
        System.out.println("cars : " + _cars);

        //특정 json 값 변경 가능하게 ObjectNode 사용
        ObjectNode objectNode = (ObjectNode) jsonNode;
        objectNode.put("name", "이재근");
        objectNode.put("age", 26);

        System.out.println(objectNode.toPrettyString());
    }
}
