package holdingObjects.genericAndTypeSafeContainers;

import java.util.ArrayList;

public class AppleAndOrangesWithoutGenerics {

    //有关“不受检查的异常”的警告信息应该被抑制
    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        ArrayList apples = new ArrayList();
        for (int i = 0; i < 3; i++){
            apples.add(new Apple());
        }

        apples.add(new Orange());

        for (int i = 0; i < apples.size(); i++){
            ((Apple)apples.get(i)).id();
        }
    }
}
