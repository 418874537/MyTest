package review.d0907;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

/**
 692. 前K个高频单词
 给一非空的单词列表，返回前 k 个出现次数最多的单词。

 返回的答案应该按单词出现频率由高到低排序。如果不同的单词有相同出现频率，按字母顺序排序。

 示例 1：

 输入: ["i", "love", "leetcode", "i", "love", "coding"], k = 2
 输出: ["i", "love"]
 解析: "i" 和 "love" 为出现次数最多的两个单词，均为2次。
 注意，按字母顺序 "i" 在 "love" 之前。


 示例 2：

 输入: ["the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"], k = 4
 输出: ["the", "is", "sunny", "day"]
 解析: "the", "is", "sunny" 和 "day" 是出现次数最多的四个单词，
 出现次数依次为 4, 3, 2 和 1 次。


 注意：

 假定 k 总为有效值， 1 ≤ k ≤ 集合元素数。
 输入的单词均由小写字母组成。


 扩展练习：

 尝试以 O(n log k) 时间复杂度和 O(n) 空间复杂度解决。
 */

public class TopKFrequentWords {
  public static List<String> topKFrequent(String[] words, int k) {
    ArrayList<String> strings = new ArrayList<>();
    HashMap<String, Integer> stringIntegerHashMap = new HashMap<>();
    for (String word : words) {
      stringIntegerHashMap.put(word,stringIntegerHashMap.get(word) == null ? 1 : stringIntegerHashMap.get(word)+1);
    }
    PriorityQueue<Map.Entry<String, Integer>> entries = new PriorityQueue<>(
        new Comparator<Map.Entry<String, Integer>>() {
          @Override
          public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
            if(o2.getValue().equals(o1.getValue())){
              Comparator<String> tComparator = Comparator.naturalOrder();
              return tComparator.compare(o1.getKey(),o2.getKey());
            }else{
              return o2.getValue() -o1.getValue();
            }

          }
        });
    entries.addAll(stringIntegerHashMap.entrySet());
    while (k>0){
      strings.add(entries.poll().getKey());
      k--;
    }
    return strings;
  }

  //自定义大顶堆:
  public static List<String> topKFrequent2(String[] words, int k) {
    ArrayList<String> result = new ArrayList<>();
    HashMap<String, Integer> map = new HashMap<String, Integer>();
    for (String word : words) {
      if(map.containsKey(word)){
        map.put(word,map.get(word)+1);
      }else{
        map.put(word,1);
      }
    }
    Comparator<String> tComparator = Comparator.naturalOrder();
    PriorityQueue<Map.Entry<String, Integer>> integers = new PriorityQueue<>(new Comparator<Map.Entry<String, Integer>>() {
      @Override
      public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
        //字母升序
        if (o1.getValue().equals(o2.getValue()) ){
          return tComparator.compare(o1.getKey(),o2.getKey());
        }else{
          //次数降序
          return o2.getValue() - o1.getValue() ;
        }
      }
    });
    integers.addAll(map.entrySet());
    for(int i = 0;i<k;i++){
      result.add(integers.poll().getKey());
    }
    return result;
  }

  public static String[] stringToStringArray(String input) {
    input = input.trim().replace("[", "").replace("]", "");
    String[] arr = input.split(",");
    for (int i = 0;i<arr.length;i++) {
      arr[i] = arr[i].trim().replace("\"","");
    }
    return arr;
  }

  public static String stringListToString(List<String> stringList) {
    StringBuilder sb = new StringBuilder("[");
    for (String item : stringList) {
      sb.append(item);
      sb.append(",");
    }

    sb.setCharAt(sb.length() - 1, ']');
    return sb.toString();
  }

  public static void main(String[] args) throws IOException {
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    String line;
    while ((line = in.readLine()) != null) {
      String[] words = stringToStringArray(line);
      line = in.readLine();
      int k = Integer.parseInt(line);

      List<String> ret = topKFrequent2(words, k);

      String out = stringListToString(ret);

      System.out.print(out);
    }
  }
}