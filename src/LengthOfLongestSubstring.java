import java.util.HashMap;

/**
 * @Description:
 * @Author: mayingjie@sensorsdata.com
 * @Date: 2021/7/27
 */
public class LengthOfLongestSubstring {
  /**
   给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
   示例 1:
   输入: s = "abcabcbb"
   输出: 3
   解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
   示例 2:
   输入: s = "bbbbb"
   输出: 1
   解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
   示例 3:
   输入: s = "pwwkew"
   输出: 3
   解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
        请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
   示例 4:
   输入: s = ""
   输出: 0
    
   提示：
   0 <= s.length <= 5 * 104
   s 由英文字母、数字、符号和空格组成
   */
  public static void main(String[] args) {
    String s = "dvdf";
    int i = new LengthOfLongestSubstring().lengthOfLongestSubstring(s);
    System.out.println(i);
  }
  public int lengthOfLongestSubstring(String s) {
    char[] chars = s.toCharArray();
    HashMap<Character, Integer> map = new HashMap<>();
    int info = -1;
    int max = 0;
    for (int i = 0;i<chars.length;i++){
      if(map.get(chars[i])!=null){
        info = map.get(chars[i])>info?map.get(chars[i]):info;

      }
      map.put(chars[i], i);
      max = i-info > max? i-info:max;

    }
    return max;
  }

}
