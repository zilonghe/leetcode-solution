class Solution(object):
    def addBinary(self, a, b):
        """
        :type a: str
        :type b: str
        :rtype: str
        """
        a_len = len(a)
        b_len = len(b)
        carry = 0
        rs = ""
        while a_len > 0 or b_len > 0 or carry > 0:
            carry += int(a[a_len-1]) if a_len > 0 else 0
            carry += int(b[b_len-1]) if b_len > 0 else 0
            rs = str(carry % 2) + rs
            carry /= 2
            a_len, b_len = a_len - 1, b_len - 1
        return rs


if __name__ == '__main__':
    print Solution().addBinary('0001', '001')