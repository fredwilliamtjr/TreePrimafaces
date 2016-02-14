package br.com.fwtj.tree;
 
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import org.primefaces.model.CheckboxTreeNode;
import org.primefaces.model.DefaultTreeNode;
import org.primefaces.model.TreeNode;
import br.com.fwtj.tree.Document;
 
@ManagedBean(name = "documentService")
@ApplicationScoped
public class DocumentService {
     
    public TreeNode createCheckboxDocuments() {
        TreeNode root = new CheckboxTreeNode(new Document("Files", "-", "Folder"), null);
         
        TreeNode documents = new CheckboxTreeNode(new Document("Documents", "-", "Folder"), root);
        documents.setSelected(true);
        TreeNode pictures = new CheckboxTreeNode(new Document("Pictures", "-", "Folder"), root);
        pictures.setSelected(true);
        TreeNode movies = new CheckboxTreeNode(new Document("Movies", "-", "Folder"), root);
        
         
        TreeNode work = new CheckboxTreeNode(new Document("Work", "-", "Folder"), documents);
        TreeNode primefaces = new CheckboxTreeNode(new Document("PrimeFaces", "-", "Folder"), documents);
         
        //Documents
        TreeNode expenses = new CheckboxTreeNode(new Document("Expenses.doc", "30 KB", "Word Document"), work);
        TreeNode resume = new CheckboxTreeNode(new Document("Resume.doc", "10 KB", "Word Document"), work);
        TreeNode refdoc = new CheckboxTreeNode(new Document("RefDoc.pages", "40 KB", "Pages Document"), primefaces);
         
        //Pictures
        TreeNode barca = new CheckboxTreeNode(new Document("barcelona.jpg", "30 KB", "JPEG Image"), pictures);
        TreeNode primelogo = new CheckboxTreeNode(new Document("logo.jpg", "45 KB", "JPEG Image"), pictures);
        TreeNode optimus = new CheckboxTreeNode(new Document("optimusprime.png", "96 KB", "PNG Image"), pictures);
         
        //Movies
        TreeNode pacino = new CheckboxTreeNode(new Document("Al Pacino", "-", "Folder"), movies);
        TreeNode deniro = new CheckboxTreeNode(new Document("Robert De Niro", "-", "Folder"), movies);
         
        TreeNode scarface = new CheckboxTreeNode(new Document("Scarface", "15 GB", "Movie File"), pacino);
        TreeNode carlitosWay = new CheckboxTreeNode(new Document("Carlitos' Way", "24 GB", "Movie File"), pacino);
         
        TreeNode goodfellas = new CheckboxTreeNode(new Document("Goodfellas", "23 GB", "Movie File"), deniro);
        TreeNode untouchables = new CheckboxTreeNode(new Document("Untouchables", "17 GB", "Movie File"), deniro);
         
        return root;
    }
}