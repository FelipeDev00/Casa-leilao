import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;

public class vendasVIEW extends JFrame {
    
    private JTable tabelaVendas; // Declaração da JTable
    private DefaultTableModel modelo; // Modelo para a JTable
    private JScrollPane scrollPane;
    ProdutosDAO produtos = new ProdutosDAO();

    public vendasVIEW() {
        setTitle("Produtos Vendidos");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());
        
        // Configuração do modelo da tabela
        modelo = new DefaultTableModel(new Object[]{"ID", "Nome", "Valor", "Status"}, 0);
        tabelaVendas = new JTable(modelo); // Cria a JTable com o modelo
        scrollPane = new JScrollPane(tabelaVendas); // Adiciona a tabela ao JScrollPane
        
        add(scrollPane, BorderLayout.CENTER); // Adiciona o JScrollPane ao frame
        
        listarProdutosVendidos(); // Popula a tabela com os produtos vendidos
    }
    private void listarProdutosVendidos() {
        // Busca os produtos vendidos
        ArrayList<ProdutosDTO> listaVendidos = produtos.listarProdutosVendidos();

        // Limpa a tabela antes de adicionar novos dados
        modelo.setRowCount(0);

        // Adiciona os dados à tabela
        for (ProdutosDTO produto : listaVendidos) {
            modelo.addRow(new Object[]{
                produto.getId(),
                produto.getNome(),
                produto.getValor(),
                produto.getStatus()
            });
        }
    }
}
