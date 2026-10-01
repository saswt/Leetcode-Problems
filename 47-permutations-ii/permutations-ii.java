class Solution {
    private List<List<Integer>> result = new ArrayList<>();
    private int n;

    public List<List<Integer>> permuteUnique(int[] nums) {
        n = nums.length;
        Map<Integer, Integer> mp = new HashMap<>();
        
        for(int num : nums) { //count occurence of each number
            mp.put(num, mp.getOrDefault(num, 0) + 1);
        }
        List<Integer> temp = new ArrayList<>();
        backtrack(temp, mp);
        return result;
    }

        private void backtrack(List<Integer> temp, Map<Integer, Integer> mp) {
            if(temp.size() == n) { //got all numbers
                result.add(new ArrayList<>(temp));
                return;
            }
            for(Map.Entry<Integer, Integer> entry : mp.entrySet()) {
                int num = entry.getKey();
                int count = entry.getValue();

                if (count == 0)
                continue;
                //do something

                temp.add(num);
                mp.put(num, count - 1);
                //explore at

                backtrack(temp, mp);

                //undo it

                temp.remove(temp.size() - 1);
                mp.put(num, count);

            }
        }
        
    }