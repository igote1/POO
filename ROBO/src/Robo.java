public class Robo {
    private Integer linha;
    private Integer coluna;
    private Integer passo;

    public Robo(Integer linha, Integer coluna){
        this.linha = linha;
        this.coluna = coluna;
        this.passo = 1;
    }
    public void MostrarPosicaoAtual (){
        for (int L = 0; L < 20; L++){
            for (int C = 0; C < 40; C++){
                if( L == getLinha() && C == getColuna()){
                    System.out.print("1");
                }else{
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
        System.out.println("\nCoordenada Atual: (" + getLinha() + "," + getColuna() + ")");
    }
    public void AndarCima (){
        if (this.linha - this.passo >= 0){
            this.linha = this.linha - this.passo;
        }else{
            setLinha(0);
        }
    }
    public void andarBaixo (){
        if (this.linha + this.passo <= 19){
            this.linha = this.linha + this.passo ;
        }else{
            setLinha(19);
        }
    }
    public void andarDireita (){
        if (this.coluna + this.passo <= 39){
            this.coluna = this.coluna + this.passo;
        }else{
            setColuna(39);
        }
    }
    public void andarEsquerda (){
        if (this.coluna - this.passo >= 0){
            this.coluna = this.coluna - this.passo;
        }else{
            setColuna(0);
        }
    }
    
    public Integer getLinha() {
        return linha;
    }
    public void setLinha(Integer linha) {
        this.linha = linha;
    }
    public Integer getColuna() {
        return coluna;
    }
    public void setColuna(Integer coluna) {
        this.coluna = coluna;
    }
    public Integer getPasso() {
        return passo;
    }
    public void setPasso(Integer passo) {
        this.passo = passo;
    }
}