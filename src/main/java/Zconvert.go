package type_strings

import (
	"fmt"
)

/*
6. Z 字形变换
将一个给定字符串 s 根据给定的行数 numRows ，以从上往下、从左到右进行 Z 字形排列。

比如输入字符串为 "PAYPALISHIRING" 行数为 3 时，排列如下：

P   A   H   N
A P L S I I G
Y   I   R
之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："PAHNAPLSIIGYIR"。

请你实现这个将字符串进行指定行数变换的函数：

string convert(string s, int numRows);


示例 1：

输入：s = "PAYPALISHIRING", numRows = 3
输出："PAHNAPLSIIGYIR"
示例 2：
输入：s = "PAYPALISHIRING", numRows = 4
输出："PINALSIGYAHRPI"
解释：
P     I    N
A   L S  I G
Y A   H R
P     I

P       H
A     S I
Y   I   R
P L     I G
A       N

示例 3：

输入：s = "A", numRows = 1
输出："A"


提示：

1 <= s.length <= 1000
s 由英文字母（小写和大写）、',' 和 '.' 组成
1 <= numRows <= 1000
 */

/*
3:
0   4   8    12
1 3 5 7 9 11 13 15
2   6   10   14

4:
0     6     12
1   5 7  11 13
2 4   8 10  14
3     9     15

5:
0       8
1     7 9      15
2   6   10  14width
3 5     1113
4       12
 */
/*
按z重排 再顺序输出
主要是二维数组的大小不好定
 */
func Convert(s string, numRows int) string {
	if numRows ==1 {
		return s
	}
	var result string
	m := map[int]map[int]string {}	
	re := make([][]string, numRows)
	numRows = numRows-1
	for i := 0; i < len(re); i++ {
		re[i] = make([]string, (len(s)/numRows/2+1) *numRows)
	}

	//re := make([][...]string, numRows+1)
	for i,v := range s{
		yu := i % numRows
		lie := i/numRows
		//偶数列
		if lie%2==0 {
			m[yu][lie/2 * numRows] = string(v)
			//re[yu][lie/2 * numRows] = string(v)
		}
		//奇数列
		if lie%2==1 {
			m[numRows][lie/2 * numRows+yu] = string(v)
			//re[numRows-yu][lie/2 * numRows+yu] = string(v)
		}
	}
	for i,arr :=range m{
		for j,_ := range arr {
			vv := re[i][j]
			//fmt.Printf("[%v][%v]:%s \n",i,j,vv)
			if(vv == ""){
				fmt.Printf("*")
			}else {
				result = result+vv
				fmt.Printf(vv)
			}

		}
		fmt.Println()
	}
	//for i,arr :=range re{
	//	for j,_ := range arr {
	//		vv := re[i][j]
	//		//fmt.Printf("[%v][%v]:%s \n",i,j,vv)
	//		if(vv == ""){
	//			fmt.Printf("*")
	//		}else {
	//			result = result+vv
	//			fmt.Printf(vv)
	//		}
	//
	//	}
	//	fmt.Println()
	//}
	return result
}
