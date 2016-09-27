class Solution(object):
    def convert(self, s, numRows):
        """
        :type s: str
        :type numRows: int
        :rtype: str
        """
        if not s or numRows <= 1 or numRows >= len(s):
            return s

        r_str = ""
        init_magic_num = numRows * 2 - 2
        str_len = len(s)
        for i in range(0, numRows):
            r_str += s[i]
            if i == 0 or i == numRows - 1:
                distance = i + init_magic_num
                while not distance > str_len - 1:
                    r_str += s[distance]
                    distance += init_magic_num
            else:
                magic_num = init_magic_num - 2*i
                distance = i + magic_num
                while not distance > str_len - 1:
                    r_str += s[distance]
                    magic_num = init_magic_num - magic_num
                    distance += magic_num
        return r_str


if __name__ == '__main__':
    print Solution().convert("PAYPALISHIRING", 5)