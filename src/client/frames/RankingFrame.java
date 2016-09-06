package client.frames;

import javax.swing.JFrame;
import java.awt.GridBagLayout;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class RankingFrame extends JFrame {

  private static final long serialVersionUID = -632911825638371863L;
  private JTable table;

  public RankingFrame( RankingLogic rankingLogic, Object [ ] [ ] ranking ) {
    setSize( new Dimension( 800, 480 ) );
    this.setLocationRelativeTo( null );
    GridBagLayout gridBagLayout = new GridBagLayout( );
    gridBagLayout.columnWidths = new int [ ] { 0, 0 };
    gridBagLayout.rowHeights = new int [ ] { 0, 0 };
    gridBagLayout.columnWeights = new double [ ] { 1.0, Double.MIN_VALUE };
    gridBagLayout.rowWeights = new double [ ] { 1.0, Double.MIN_VALUE };
    getContentPane( ).setLayout( gridBagLayout );

    JScrollPane scrollPane = new JScrollPane( );
    GridBagConstraints gbc_scrollPane = new GridBagConstraints( );
    gbc_scrollPane.fill = GridBagConstraints.BOTH;
    gbc_scrollPane.gridx = 0;
    gbc_scrollPane.gridy = 0;
    getContentPane( ).add( scrollPane, gbc_scrollPane );

    DefaultTableModel tableModel = new DefaultTableModel( );
    tableModel.addColumn( "login" );
    tableModel.addColumn( "points" );

    for ( int i = 0; i < ranking.length; i++ ) {
      tableModel.addRow( ranking );
    }

    for ( int i = 0; i < ranking.length; i++ ) {
      tableModel.setValueAt( ranking[ i ][ 0 ].toString( ), i, 0 );
      tableModel.setValueAt( ranking[ i ][ 1 ].toString( ), i, 1 );
    }

    table = new JTable( tableModel );
    scrollPane.setViewportView( table );
    setVisible( true );
  }

}
