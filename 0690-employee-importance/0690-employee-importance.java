/*
// Definition for Employee.
class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
};
*/

class Solution {
    Map<Integer, Employee> map;
    public int getImportance(List<Employee> emp, int id) {
        map = new HashMap<>();
        for(var e: emp)
            map.put(e.id, e);
        return dfs(id);
    }
    int dfs(int id){
        int ans = map.get(id).importance;
        for(var subId: map.get(id).subordinates)
            ans += dfs(subId);
        return ans;
    }
}

// // wont work
//
// class Solution {
//     public int getImportance(List<Employee> emp, int id) {
//         int ans = emp.get(id).importance;
//         for(var sub: emp.get(id).subordinates)
//             ans += getImportance(emp, sub);
//         return ans;
//     }
// }