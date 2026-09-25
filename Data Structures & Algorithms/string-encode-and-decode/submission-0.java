class Solution {

    public String encode(List<String> strs) {
        //4#String1,5
        // Number indicates the length of the 
        StringBuilder sb = new StringBuilder();
        for(String s : strs) {
            sb.append(s.length()).append("#").append(s);
        }
        return sb.toString();


    }

    public List<String> decode(String str) {
        List<String> result = new ArrayList<>();
        boolean findStringLength = true;
        StringBuilder sLength = new StringBuilder();
        int i = 0;
        while(i < str.length()) {
            char current = str.charAt(i);
            if(current == '#') {
                int len = Integer.parseInt(sLength.toString());
                // move onto index of start of str
                i++;
                result.add(str.substring(i, i + len));
                i += len;
                // reset
                sLength = new StringBuilder();
            }
            else {
                // continue getting number
                sLength.append(current);
                i++;
            }
        }
        return result;
    }
}
