/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package conversorbdweka.xml;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import conversorbdweka.xml.estrutura.Caracterizacao;
import conversorbdweka.xml.estrutura.Comorbidades;
import conversorbdweka.xml.estrutura.DadosClinicos;
import conversorbdweka.xml.estrutura.DorCardiacaIsquemica;
import conversorbdweka.xml.estrutura.DorCardiacaNaoIsquemica;
import conversorbdweka.xml.estrutura.DorNaoCardiaca;
import conversorbdweka.xml.estrutura.DorNoExame;
import conversorbdweka.xml.estrutura.Hipotese;
import conversorbdweka.xml.estrutura.HistoricoClinico;
import conversorbdweka.xml.estrutura.Intensidade;
import conversorbdweka.xml.estrutura.Investigacao;
import conversorbdweka.xml.estrutura.LocalizacaoIrradiacao;
import conversorbdweka.xml.estrutura.Medicamentos;
import conversorbdweka.xml.estrutura.MotivoExameSemDor;
import conversorbdweka.xml.estrutura.SintomasAssociados;
import conversorbdweka.xml.estrutura.Solicitante;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;

/**
 *
 * @author Igor
 */
public class XMLFactory<T> {

    /**
     * MÃ©todo da clase XMLFactory utilizado para gerar um xml a partir de uma
     * estrutura prÃ©-definida em seu fonte.
     *
     * @param estrutura objeto de estrutura do xml, modelos disponiveis -
     * MODELOHISTORICOCLINICO.class, HISTORICOCLINICO.class, CONTEUDOEXAME.class
     * @param encoding formato em que serÃ¡ codificado o xml.
     * @return um objeto String com o conteudo gerado em forma de xml.
     */
    public String gerarXML(T estrutura, String encoding) {
        XStream stream = new XStream(new DomDriver(encoding));

        // MODELO HISTORICO CLINICO
        stream.alias("MODELOHISTORICOCLINICO", MODELOHISTORICOCLINICO.class);
        stream.alias("DEFINICAO", DEFINICAO.class);
        stream.alias("VALOR", VALOR.class);
        stream.alias("STYLE", STYLE.class);
        // HISTORICO CLINICO
        stream.alias("HISTORICOCLINICO", HISTORICOCLINICO.class);
        stream.alias("DADOCLINICO", DADOCLINICO.class);
        stream.alias("GRUPO", GRUPO.class);
        // CONTEUDO EXAME
        stream.alias("CONTEUDOEXAME", CONTEUDOEXAME.class);
        stream.alias("REGISTRO", REGISTRO.class);
        stream.alias("CANAL", CANAL.class);
        //LAUDO
        stream.alias("LAUDO", LAUDO.class);
        
        return stream.toXML(estrutura);
    }

    /**
     * MÃ©todo da classe XMLFacttory utilizado para gerar uma estrutura a partir
     * de um xml.
     *
     * @param XML xml em formato de String, obdecer modelo de estrutura
     * MODELOHISTORICOCLINICO.class, HISTORICOCLINICO.class, CONTEUDOEXAME.class
     * @param encoding formato em que serÃ¡ decodificado o xml
     * @return retorna um objeto especifico de acordo com um tipo definido na
     * instÃ¢ncia;
     */
    public T gerarEstrutura(String XML, String encoding) {
        XStream stream = new XStream(new DomDriver(encoding));

        // MODELO HISTORICO CLINICO
        stream.alias("MODELOHISTORICOCLINICO", MODELOHISTORICOCLINICO.class);
        stream.alias("DEFINICAO", DEFINICAO.class);
        stream.alias("VALOR", VALOR.class);
        stream.alias("STYLE", STYLE.class);
        // HISTORICO CLINICO
        stream.alias("HISTORICOCLINICO", HISTORICOCLINICO.class);
        stream.alias("DADOCLINICO", DADOCLINICO.class);
        stream.alias("GRUPO", GRUPO.class);
        // CONTEUDO EXAME
        stream.alias("CONTEUDOEXAME", CONTEUDOEXAME.class);
        stream.alias("REGISTRO", REGISTRO.class);
        stream.alias("CANAL", CANAL.class);
        //LAUDO
        stream.alias("LAUDO", LAUDO.class);
        
        T object = null;
        object = (T) stream.fromXML(XML);

        return object;
    }

    /**
     * MÃ©todo da classe XMLFacttory utilizado para gerar uma estrutura a partir
     * de um xml.
     *
     * @param XML xml em formato de File, obdecer modelo de estrutura
     * MODELOHISTORICOCLINICO.class, HISTORICOCLINICO.class, CONTEUDOEXAME.class
     * @param encoding formato em que serÃ¡ decodificado o xml
     * @return retorna um objeto especifico de acordo com um tipo definido na
     * instÃ¢ncia;
     */
    public T gerarEstrutura(File XML, String encoding) {
        XStream stream = new XStream(new DomDriver(encoding));

        // MODELO HISTORICO CLINICO
        stream.alias("MODELOHISTORICOCLINICO", MODELOHISTORICOCLINICO.class);
        stream.alias("DEFINICAO", DEFINICAO.class);
        stream.alias("VALOR", VALOR.class);
        stream.alias("STYLE", STYLE.class);
        // HISTORICO CLINICO
        stream.alias("HISTORICOCLINICO", HISTORICOCLINICO.class);
        stream.alias("DADOCLINICO", DADOCLINICO.class);
        stream.alias("GRUPO", GRUPO.class);
        // CONTEUDO EXAME
        stream.alias("CONTEUDOEXAME", CONTEUDOEXAME.class);
        stream.alias("REGISTRO", REGISTRO.class);
        stream.alias("CANAL", CANAL.class);
        //LAUDO
        stream.alias("LAUDO", LAUDO.class);
        
        try {
            Reader reader = new FileReader(XML);
            T object = (T) stream.fromXML(reader);

            return object;
        } catch (FileNotFoundException ex) {
            return null;
        }
    }

    public HistoricoClinico gerarHistoricoClinicoXMLAntigo(String XML, String encoding) {
        XStream stream = new XStream(new DomDriver(encoding));
        stream.alias("HISTORICOCLINICO", HistoricoClinico.class);
        stream.alias("DADOSCLINICOS", DadosClinicos.class);
        stream.alias("SOLICITANTE", Solicitante.class);
        stream.alias("MEDICAMENTOSEMUSO", Medicamentos.class);
        stream.alias("COMORBIDADESEFATORESEMRISCO", Comorbidades.class);
        stream.alias("HIPOTESEDIAGNOSTICA", Hipotese.class);
        stream.alias("INVESTIGACAODADOR", Investigacao.class);
        stream.alias("DORNOEXAME", DorNoExame.class);
        stream.alias("LOCALIZACAOIRRADIACAODADOR", LocalizacaoIrradiacao.class);
        stream.alias("SINTOMASASSOCIADOS", SintomasAssociados.class);
        stream.alias("INTENSIDADEDADOR", Intensidade.class);
        stream.alias("CARACTERIZACAODADORTORACICA", Caracterizacao.class);       
        stream.alias("DORCARDIACAISQUEMICA", DorCardiacaIsquemica.class);
        stream.alias("DORCARDIACANAOISQUEMICA", DorCardiacaNaoIsquemica.class);
        stream.alias("DORNAOCARDIACA", DorNaoCardiaca.class);
        stream.alias("MOTIVOEXAMESEMDOR", MotivoExameSemDor.class);

        return (HistoricoClinico) stream.fromXML(XML);
    }

    public CONTEUDOEXAME gerarConteudoExameXMLAntigo(String XML, String encoding) {
        XML = XML.replaceAll("</SENSIBILIDADE>", "</SENSIBILIDADE><REGISTROS>");
        XML = XML.replaceAll("</CONTEUDOEXAME>", "</REGISTROS></CONTEUDOEXAME>");
        return (CONTEUDOEXAME) gerarEstrutura(XML, encoding);
    }
}
