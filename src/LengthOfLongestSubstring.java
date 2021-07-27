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
    Integer length = 0;
    for(int i = 0;i<chars.length;i++){
      if(map.get(chars[i])!=null){
        int size = map.size();
        if(size>length){
          length = size;
        }
        map.clear();
      }
      map.put(chars[i],i);
      System.out.println(length);
    }
    int size = map.size();
    if(size>length){
      length = size;
    }
    return length;
  }

  /**
   * 字符串是否有重复字符
   * @param substring
   * @return
   */
  private boolean hasRepet(String substring) {
    char[] chars = substring.toCharArray();
    HashMap<Character, Integer> map = new HashMap<>();
    for (char c:chars){
      if(map.get(c)!=null){
        return true;
      }else {
        map.put(c,1);
      }
    }
    return false;
  }
}
