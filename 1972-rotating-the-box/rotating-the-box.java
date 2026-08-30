class Solution {
    public char[][] rotateTheBox(char[][] boxGrid) {
     int m = boxGrid.length;
     int n = boxGrid[0].length;
     // rotate a new result array with dimensions swapped
     char[][] result = new char[n][m];
     //transpose the bocx
     for (int i = 0; i  < n; i++){
        for (int j = 0; j < m; j++){
            result[i][j] = boxGrid[j][i];
        }
     }   
     //reverse each row to achieve a 90 degree roatation
     for (int i = 0; i < n; i++){
        reverseRow(result[i]);
     }
     //apply gravity
     for(int j = 0; j < m; j++) {
        for(int i = n - 1; i >= 0; i--) {
            if(result[i][j] == '.') {
                //If it's a space
               int stoneRow = -1;
               //look for some nearest stone
               for(int k = i - 1; k >= 0; k--) {
                if(result[k][j] == '*'){
                    break;
                } else if(result[k][j] == '#') {
                  stoneRow = k;
                  break;
                }
               }
               if(stoneRow != -1) {
                result[i][j] = '#';
                result [stoneRow][j] = '.';
               }
            }
        }
     }
     return result;
    }
//helper method to reverse a row
private void reverseRow(char[] row){
    int left = 0; 
    int right = row.length - 1;
    while (left < right) {
        char temp = row[left];
        row[left] = row[right];
        row[right] = temp;
        left++;
        right--;
    }
}
}
// BRUTE FORCE METHOD SOLVED USING THREE(3) LOOPS
//TIME COMPLEXITY(TC): O(col * row * row)