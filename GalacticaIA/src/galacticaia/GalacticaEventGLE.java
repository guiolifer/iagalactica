package galacticaia;

import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLAutoDrawable;
import com.jogamp.opengl.GLEventListener;

public class GalacticaEventGLE implements GLEventListener {

    private final Coordenada[][] campo;
    private final Integer[][] caminho;
    private final Campo iniciarCampo;
    
    

    GalacticaEventGLE(Campo iniciarCampo) {
        this.campo = iniciarCampo.getCampo();
        this.caminho = iniciarCampo.getCaminho();
        this.iniciarCampo = iniciarCampo;
    }

    

    

    @Override
    public void init(GLAutoDrawable drawable) {
        
    }

    @Override
    public void dispose(GLAutoDrawable drawable) {
        
    }

    @Override
    public void display(GLAutoDrawable drawable) {
        final GL2 gl = drawable.getGL().getGL2();

        
        gl.glClear(GL2.GL_COLOR_BUFFER_BIT | GL2.GL_DEPTH_BUFFER_BIT);
        gl.glLoadIdentity();
        
        int linha = this.campo.length;
        int coluna = this.campo[0].length;
        
        for (int i = 0; i < linha; i++) {
            for (int j = 0; j < coluna; j++) {
                
                switch (this.campo[i][j].getCusto()) {
                    case 200:
                        gl.glColor3f( 0.2f,0.29f,0.29f );
                        break;
                    case 5:
                        gl.glColor3f( 0.3f,0.3f,0.3f );
                        break;
                    case 1:
                        gl.glColor3f( 1f,1f,1f );
                        break;
                    case 0:
                        gl.glColor3f( 0.8f,0.4f,0.1f );
                        break;
                    default:
                        gl.glColor3f( 0.0f,0.0f,0.0f );
                        break;
                }
                
                if(iniciarCampo.getCoorIni().getLinha() == i && iniciarCampo.getCoorIni().getColuna() == j){
                    gl.glColor3f( 1f,0f,0f );
                }
                
                if(iniciarCampo.getCoorFim().getLinha() == i && iniciarCampo.getCoorFim().getColuna() == j){
                    gl.glColor3f( 0f,1f,0f );
                }
                
                if(caminho[i][j]==1){
                    gl.glColor3f( 0.8f,0.2f,0.2f );
                }else if(caminho[i][j]==2){
                    gl.glColor3f( 0.9f,0.7f,0.2f );
                }
                this.desenhaQuadrado(gl, i, j);
            }
        }
        
        
        

        
        gl.glFlush();
    }

    @Override
    public void reshape(GLAutoDrawable drawable, int x, int y, int width, int height) {
        
    }
    
    private void desenhaQuadrado(GL2 gl,float x,float y){
        float cuboX = -0.98f+(y*0.06f);
        float cuboY = 0.98f-(x*0.06f);
        
        gl.glBegin(GL2.GL_QUADS);
        gl.glVertex3f(cuboX, cuboY, 0);//superior esquerdo
        gl.glVertex3f(cuboX+0.048f, cuboY, 0);//superior direito
        gl.glVertex3f(cuboX+0.048f, cuboY-0.048f, 0);//
        gl.glVertex3f(cuboX, cuboY-0.048f, 0);
        gl.glEnd(); 
    }
    
    

}
