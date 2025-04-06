class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int startColor = image[sr][sc];
        if(startColor == color){
            return image;
        }
        dfs(image,sr,sc,color,startColor);
        return image;
    }
    private void dfs(int[][] image,int sr,int sc,int color,int startColor){
        if(sr<0||sc<0||sr>=image.length||sc>=image[0].length){
            return;
        }
        if(image[sr][sc] != startColor){
            return;
        }
        image[sr][sc] = color;
        dfs(image,sr+1,sc,color,startColor);
        dfs(image,sr-1,sc,color,startColor);
        dfs(image,sr,sc+1,color,startColor);
        dfs(image,sr,sc-1,color,startColor);
    }
}