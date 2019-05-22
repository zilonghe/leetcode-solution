class solution(object):
    def firstUniqChar(self, s=''):
        """
        :type s: str
        :rtype: int
        """
        if not s:
            return -1
        for x in xrange(0, len(s)):
            cur = s[x]
            if s.find(cur) == s.rfind(cur):
                return x
        return -1
