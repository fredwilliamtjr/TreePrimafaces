package br.com.fwtj.tree;
 
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import org.primefaces.model.TreeNode;
 
@ManagedBean(name="treeSelectionView")
@ViewScoped
public class SelectionView implements Serializable {
     
    
    private TreeNode root3;
    
    private TreeNode[] selectedNodes2;
     
    @ManagedProperty("#{documentService}")
    private DocumentService service;
     
    @PostConstruct
    public void init() {
        
        root3 = service.createCheckboxDocuments();
    }

    public TreeNode getRoot3() {
        return root3;
    }
 
    public TreeNode[] getSelectedNodes2() {
        return selectedNodes2;
    }
 
    public void setSelectedNodes2(TreeNode[] selectedNodes2) {
        this.selectedNodes2 = selectedNodes2;
    }
 
    public void setService(DocumentService service) {
        this.service = service;
    }
 
    public void displaySelectedMultiple(TreeNode[] nodes) {
        if(nodes != null && nodes.length > 0) {
            StringBuilder builder = new StringBuilder();
 
            for(TreeNode node : nodes) {
                builder.append(node.getData().toString());
                builder.append("<br />");
                if (node.getData().toString().equals("Documents")) {
                    System.out.println("Documento Selecionado");
                }
                if (node.getData().toString().equals("Pictures")) {
                    System.out.println("Fotos Selecionado");
                }
                if (node.getData().toString().equals("Movies")) {
                    System.out.println("Filmes Selecionado");
                }
            }
 
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Selected", builder.toString());
            FacesContext.getCurrentInstance().addMessage(null, message);
        }
    }
}