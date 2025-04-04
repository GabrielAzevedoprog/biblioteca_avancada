import java.util.ArrayList;

public class Biblioteca {
    private final ArrayList<Material> materiais;

    public Biblioteca() {
        materiais = new ArrayList<>();
    }

    // Adicionar um material
    public void adicionarMaterial(Material material) {
        materiais.add(material);
    }

    // Listar todos os materiais
    public void listarMateriais() {
        for (Material material : materiais) {
            material.exibirDetalhes();
        }
    }

    // Pesquisar material por título
    public Material pesquisarPorTitulo(String titulo) {
        for (Material material : materiais) {
            if (material.getTitulo().equalsIgnoreCase(titulo)) {
                return material;
            }
        }
        return null; // Não encontrado
    }

    // Excluir material por título
    public boolean excluirPorTitulo(String titulo) {
        Material material = pesquisarPorTitulo(titulo);
        if (material != null) {
            materiais.remove(material);
            return true;
        }
        return false; // Não encontrado
    }
}
