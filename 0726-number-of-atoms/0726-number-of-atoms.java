class Solution {
    public String countOfAtoms(String formula) {
        Stack<KeyValue> stack = new Stack<>();
        for (int i = 0; i < formula.length(); i ++){
            if (formula.charAt(i) == '('){
                stack.push(new KeyValue("(", 0));
                continue;
            }
            if (formula.charAt(i) == ')'){
                List<KeyValue> toAdd = new ArrayList<>();
                int[] values = findValue(formula, i);
                i = values[1];
                int multi = values[0];
                while (stack.peek().key != "("){
                    KeyValue found = stack.pop();
                    found.count *= multi;
                    toAdd.add(found);
                }
                stack.pop();
                for (KeyValue v: toAdd){
                    stack.push(v);
                }
                continue;
            }
            StringBuilder sb = new StringBuilder();
            sb.append(formula.charAt(i));
            while (i + 1 < formula.length() && Character.isLowerCase(formula.charAt(i + 1))){
                i ++;
                sb.append(formula.charAt(i));
            }
            int[] values = findValue(formula, i);
            i = values[1];
            int multi = values[0];
            stack.push(new KeyValue(sb.toString(), multi));
        }

        TreeMap<String, Integer> finalMap = new TreeMap<>();
        while (stack.size() > 0){
            KeyValue found = stack.pop();
            int count = finalMap.getOrDefault(found.key, 0);
            finalMap.put(found.key, count + found.count);
        }
        
        StringBuilder sb = new StringBuilder();
        for (String s: finalMap.keySet()){
            int count = finalMap.get(s);
            if (count == 1){
                sb.append(s);
                continue;
            }
            sb.append(s + String.valueOf(count));
        }
        return sb.toString();
    }

    private int[] findValue(String formula, int i){
        int multi = 0;
        while (i + 1 < formula.length() && Character.isDigit(formula.charAt(i + 1))){
            i ++;
            multi = multi * 10 + formula.charAt(i) - '0';                    
        }
        if (multi == 0){
            multi = 1;
        }
        return new int[]{multi, i};
    }
}

class KeyValue {
    public String key;
    public int count;

    public KeyValue(String key, int count){
        this.key = key;
        this.count = count;
    }
}