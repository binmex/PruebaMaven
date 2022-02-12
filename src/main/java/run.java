import edu.uci.ics.jung.algorithms.layout.CircleLayout;
import edu.uci.ics.jung.algorithms.shortestpath.DijkstraDistance;
import edu.uci.ics.jung.algorithms.shortestpath.DijkstraShortestPath;
import edu.uci.ics.jung.graph.DirectedSparseGraph;
import edu.uci.ics.jung.graph.UndirectedSparseGraph;
import edu.uci.ics.jung.visualization.VisualizationImageServer;
import edu.uci.ics.jung.visualization.VisualizationViewer;
import edu.uci.ics.jung.visualization.decorators.ToStringLabeller;
import javax.swing.*;
import java.awt.*;

public class run{
    public static void main(String[] args) {
        UndirectedSparseGraph g = new UndirectedSparseGraph();

        g.addVertex("vertex1");
        g.addVertex("vertex2");
        g.addVertex("vertex3");
        g.addVertex("vertex4");
        g.addVertex("vertex5");

        g.addEdge("edge1","vertex1","vertex2");
        g.addEdge("edge2","vertex1","vertex5");
        g.addEdge("edge3","vertex5","vertex4");
        g.addEdge("edge4","vertex2","vertex4");
        g.addEdge("edge5","vertex5","vertex2");
        g.addEdge("edge6","vertex2","vertex3");
        g.addEdge("edge7","vertex4","vertex3");

        //Establecer etiquetas
        VisualizationViewer<Integer,String> q = new VisualizationViewer<Integer,String>(new CircleLayout(g));
        q.getRenderContext().setEdgeLabelTransformer(new ToStringLabeller());
        q.getRenderContext().setVertexLabelTransformer(new ToStringLabeller());


        DijkstraDistance s = new DijkstraDistance(g);
        s.getDistance("vertex1","vertex3");

        DijkstraShortestPath j = new DijkstraShortestPath(g);
        for (int i = 1; i <= 5; i++) {
            System.out.println(j.getPath("vertex"+i,"vertex5"));

            JOptionPane.showMessageDialog(null,j.getPath("vertex"+i,"vertex5"));
        }



        VisualizationImageServer vs =
                new VisualizationImageServer(
                        new CircleLayout(g), new Dimension(200,200));



        //vs.getRenderContext().setVertexFillPaintTransformer(g.);
        vs.getRenderContext().setVertexFillPaintTransformer((p) -> {
            if ("vertex1" == "")
                return Color.BLACK;
            else
                return Color.yellow;

        });
        JFrame frame = new JFrame();
       // frame.getContentPane().add(vs);
        frame.getContentPane().add(q);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);


    }
}
