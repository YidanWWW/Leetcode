package amazon;
int solution(string s){
    int nA=0;
    int nZ=0;
    int res=0;
    for(int i=0;i<s.length();i++){
        if(s[i]=='A')
            nA++;
        if(s[i]=='Z'){
            res += nA;
            nZ++;
        }
    }
    res += max(nA,nZ);
    return res;
}