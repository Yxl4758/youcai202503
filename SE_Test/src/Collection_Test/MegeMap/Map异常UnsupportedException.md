Map异常UnsupportedException

```
public class Test {
    public static void main(String[] args) {
        Map<String, Integer> map1 = Map.of("A", 1, "B", 2, "C", 3);
        Map<String, Integer> newMap1 = new HashMap<>(map1);
        Map<String, Integer> map2 = Map.of("B", 4, "C", 5, "D", 6);
        Map<String, Integer> newMap2 = new HashMap<>(map2);
        Map<String, Integer> newMap = mergeMap(newMap1,newMap2);
        System.out.println(newMap);
    }
    public static Map<String,Integer> mergeMap(Map<String, Integer> map1, Map<String,Integer> map2){
        Set<String> keySet = map2.keySet();
        for(String key : keySet){
            if(map1.containsKey(key)){
                map1.replace(key, map1.get(key),map1.get(key) + map2.get(key));
            }else {
                map1.put(key,map2.get(key));
            }
        }
        return map1;
    }
}
```

![](F:\Java培训\typroa图片\MapExcepton.png)

Map.of不支持replace方法，会抛出UnsupportedException，将map1和map2替换为新的HashMap类型