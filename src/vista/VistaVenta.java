/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import modelo.*;
import controlador.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author usuario
 */
public class VistaVenta extends javax.swing.JFrame {


    public VistaVenta(Tienda tienda) {
        initComponents();
        //this.setControlador(new Controlador(this));
        this.setTienda(tienda);
        setVisible(true);                                
        jTableProductos.setVisible(false);        
        jTableDetaVenta.setVisible(false);
        jLabel1.setVisible(false);
        jLabel2.setVisible(false);
        jLabel3.setVisible(false);
        jLabel5.setVisible(false);
        jTextFieldBuscarProducto.setVisible(false);
        jTextFieldCantidad.setVisible(false);
        jButtonAgregar.setVisible(false);
        jButtonAceptar.setVisible(false);
        jComboBoxRubro.setVisible(false);
        jLabel4.setVisible(false);
        jTextFieldCodigo.setVisible(false);
        jLabel6.setVisible(false);
        jTextFieldTotal.setVisible(false);
        jTableDetaVenta.setVisible(true);
        jTableProductos.setVisible(false);
        
        jButtonAgregar.setVisible(false);
        jButtonAceptar.setVisible(false);
        jTextFieldCodigo.setEditable(false);

    }

    private Tienda tienda;
    private Controlador controlador;

    public Tienda getTienda() {
        return tienda;
    }

    public void setTienda(Tienda tienda) {
        this.tienda = tienda;
    }

    public Controlador getControlador() {
        return controlador;
    }

    public void setControlador(Controlador controlador) {
        this.controlador = controlador;
    }

    public VistaVenta() {
    }

    private Venta venta = new Venta();
    private Turno turno = new Turno();
    //private CatalogoProducto catalogo = new CatalogoProducto();
    private DefaultTableModel modeloTabla1 = new DefaultTableModel();
    private DefaultTableModel modeloTabla2 = new DefaultTableModel() {
        @Override
        public boolean isCellEditable(int row, int column) {
            if (column >= 3) {
                return true;
            } else {
                return false;
            }
        }

        @Override
        public Class getColumnClass(int columna) {
            if (columna >= 3) {
                return (Boolean.class);
            }
            return super.getColumnClass(columna);
        }
    };
    TableRowSorter trs;

    public Venta getV() {
        return venta;
    }

    public void setV(Venta v) {
        this.venta = v;
    }

    public Turno getT() {
        return turno;
    }

    public void setT(Turno t) {
        this.turno = t;
    }

//    public CatalogoProducto getProductos() {
//        return catalogo;
//    }
//
//    public void setProductos(CatalogoProducto productos) {
//        this.catalogo = productos;
//    }
    public DefaultTableModel getModeloTabla() {
        return modeloTabla1;
    }

    public void setModeloTabla(DefaultTableModel modeloTabla) {
        this.modeloTabla1 = modeloTabla;
    }

//    public void mostrarRubro(CatalogoProducto catalogo) {
//        for (int i = 0; i < catalogo.getRubros().size(); i++) {
//            jComboBoxRubro.addItem(catalogo.getRubros().get(i).toString());
//        }
//
//    }
//    @Override
//    public void mostrarDetaVenta(Venta v) {
//        modeloTabla1.setColumnCount(0);
//        modeloTabla1.setNumRows(0);
//        modeloTabla1.addColumn("Codigo");
//        modeloTabla1.addColumn("Nombre");
//        modeloTabla1.addColumn("Cantidad");
//        modeloTabla1.addColumn("Precio");
//        for (int i = 0; i < v.getLineasVenta().size(); i++) {
//            Object[] fila = new Object[4];
//            fila[0] = v.getLineasVenta().get(i).getProducto().getId_Producto();
//            fila[1] = v.getLineasVenta().get(i).getProducto().getNombre();
//            fila[2] = v.getLineasVenta().get(i).getCantidad();
//            fila[3] = v.getLineasVenta().get(i).getSubTotal();
//            modeloTabla1.addRow(fila);
//        }
//        jTableDetaVenta.setModel(modeloTabla1);
//        jTableDetaVenta.getColumnModel().getColumn(0).setPreferredWidth(50);
//        jTableDetaVenta.getColumnModel().getColumn(1).setPreferredWidth(200);
//        jTableDetaVenta.getColumnModel().getColumn(2).setPreferredWidth(50);
//        jTableDetaVenta.getColumnModel().getColumn(3).setPreferredWidth(50);
//        jTextFieldTotal.setText("" + v.getTotal());
//    }

//    @Override
//    public void mostrarProductos(CatalogoProducto catalogo) {
//        System.out.println(catalogo.getProductos().size());
//        modeloTabla2.setColumnCount(0);
//        modeloTabla2.setNumRows(0);
//        modeloTabla2.addColumn("Codigo");
//        modeloTabla2.addColumn("Nombre");
//        modeloTabla2.addColumn("Precio");
//        //for (int i = 0; i < catalogo.getProductos().size(); i++) {
//            Iterator<Producto> iter = catalogo.getProductos().iterator();
//            while (iter.hasNext()) {
//                Producto p = iter.next();
//                Object[] fila = new Object[3];
//                fila[0] = p.getId_Producto();
//                fila[1] = p.getNombre();
//                fila[2] = p.getPrecio();
//                modeloTabla2.addRow(fila);
//            }
//        //}
//        jTableProductos.setModel(modeloTabla2);
//        jTableProductos.getColumnModel().getColumn(0).setPreferredWidth(50);
//        jTableProductos.getColumnModel().getColumn(1).setPreferredWidth(200);
//        jTableProductos.getColumnModel().getColumn(2).setPreferredWidth(50);
//
//    }

    public void mostrarSandwich(Producto sandwich, String c) {
        int cantidad = Integer.parseInt(c);        
        modeloTabla2.setColumnCount(0);
        modeloTabla2.setNumRows(0);
        modeloTabla2.addColumn("Codigo");
        modeloTabla2.addColumn("Nombre del Producto");
        modeloTabla2.addColumn("Precio");
        for (Agregado agregado : sandwich.getAgregado()) {
            modeloTabla2.addColumn(agregado.getProducto().getNombre());
        }
//        modeloTabla2.addColumn("Lechuga");
//        modeloTabla2.addColumn("Tomate");
//        modeloTabla2.addColumn("Mostaza");
//        modeloTabla2.addColumn("Jamon");
//        modeloTabla2.addColumn("Queso");
//        modeloTabla2.addColumn("Huevo");

        Object[] fila = new Object[sandwich.getAgregado().size() + 3];
        fila[0] = sandwich.getId_Producto();
        fila[1] = sandwich.getNombre();
        fila[2] = sandwich.getPrecio();
        for (int i = 0; i < sandwich.getAgregado().size(); i++){
            fila[i+3] = sandwich.getAgregado().get(i).isIncluido();           
        }
        for (int i = 0; i < cantidad; i++) {       
            modeloTabla2.addRow(fila);
        }
//        for (int i = 0; i < sandwich.getAgregado().size(); i++) {
//            jTableProductos.setValueAt(sandwich.getAgregado().get(i).getProducto().getId_Producto(), cantidad + 1, i + 3);
//        }
        
        jTableProductos.setModel(modeloTabla2);
        jTableProductos.getColumnModel().getColumn(0).setPreferredWidth(20);
        jTableProductos.getColumnModel().getColumn(1).setPreferredWidth(200);
        jTableProductos.getColumnModel().getColumn(2).setPreferredWidth(10);
        for (int i = 0; i < sandwich.getAgregado().size(); i++) {
            jTableProductos.getColumnModel().getColumn(i + 3).setPreferredWidth(10);
        }
        
    }

     /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuBar2 = new javax.swing.JMenuBar();
        jMenu3 = new javax.swing.JMenu();
        jMenu4 = new javax.swing.JMenu();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableProductos = new javax.swing.JTable();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableDetaVenta = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jTextFieldBuscarProducto = new javax.swing.JTextField();
        jTextFieldCantidad = new javax.swing.JTextField();
        jButtonAgregar = new javax.swing.JButton();
        jButtonAceptar = new javax.swing.JButton();
        jComboBoxRubro = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jTextFieldCodigo = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jTextFieldTotal = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        jMenu5 = new javax.swing.JMenu();
        jMenuNuevaVenta = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();

        jMenu3.setText("File");
        jMenuBar2.add(jMenu3);

        jMenu4.setText("Edit");
        jMenuBar2.add(jMenu4);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jScrollPane2.setToolTipText("");

        jTableProductos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Producto", "Precio", "Lechuga", "Tomate", "Mostaza", "Jamón", "Queso", "Huevo"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Boolean.class, java.lang.Boolean.class, java.lang.Boolean.class, java.lang.Boolean.class, java.lang.Boolean.class, java.lang.Boolean.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jTableProductos.setColumnSelectionAllowed(true);
        jTableProductos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableProductosMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTableProductos);
        jTableProductos.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);

        jTableDetaVenta.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Producto", "Precio Unitario", "Cantidad", "Subtotal"
            }
        ));
        jTableDetaVenta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableDetaVentaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTableDetaVenta);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("NUEVA VENTA");

        jLabel2.setText("Buscar Productos:");

        jLabel3.setText("Cantidad:");

        jLabel5.setText("Pedido");

        jTextFieldBuscarProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldBuscarProductoActionPerformed(evt);
            }
        });
        jTextFieldBuscarProducto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextFieldBuscarProductoKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldBuscarProductoKeyTyped(evt);
            }
        });

        jTextFieldCantidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldCantidadActionPerformed(evt);
            }
        });
        jTextFieldCantidad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldCantidadKeyTyped(evt);
            }
        });

        jButtonAgregar.setText("Agregar");
        jButtonAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAgregarActionPerformed(evt);
            }
        });

        jButtonAceptar.setText("Aceptar");
        jButtonAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAceptarActionPerformed(evt);
            }
        });

        jComboBoxRubro.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "RUBRO" }));
        jComboBoxRubro.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jComboBoxRubroMouseClicked(evt);
            }
        });

        jLabel4.setText("Codigo:");

        jTextFieldCodigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldCodigoActionPerformed(evt);
            }
        });

        jLabel6.setText("Total: ");

        jButton1.setText("Cancelar");

        jMenuBar1.add(jMenu1);
        jMenuBar1.add(jMenu2);

        jMenu5.setText("Menu");

        jMenuNuevaVenta.setText("Nueva Venta");
        jMenuNuevaVenta.addMenuKeyListener(new javax.swing.event.MenuKeyListener() {
            public void menuKeyPressed(javax.swing.event.MenuKeyEvent evt) {
            }
            public void menuKeyReleased(javax.swing.event.MenuKeyEvent evt) {
                jMenuNuevaVentaMenuKeyReleased(evt);
            }
            public void menuKeyTyped(javax.swing.event.MenuKeyEvent evt) {
            }
        });
        jMenuNuevaVenta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenuNuevaVentaMouseClicked(evt);
            }
        });
        jMenu5.add(jMenuNuevaVenta);

        jMenuItem1.setText("Cerrar Sesion");
        jMenuItem1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenuItem1MouseClicked(evt);
            }
        });
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu5.add(jMenuItem1);

        jMenuBar1.add(jMenu5);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(432, 432, 432)
                .addComponent(jLabel6)
                .addContainerGap(617, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jTextFieldTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(jScrollPane1))))
                .addGap(466, 466, 466))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane2)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jButtonAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(jLabel1)
                                            .addGap(92, 92, 92))
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(jLabel2)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(jTextFieldBuscarProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(30, 30, 30)
                                            .addComponent(jLabel4)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(jTextFieldCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(22, 22, 22)))
                                    .addComponent(jLabel3)
                                    .addGap(18, 18, 18)
                                    .addComponent(jTextFieldCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(63, 63, 63)
                                    .addComponent(jComboBoxRubro, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(532, 532, 532)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(69, 69, 69)
                                .addComponent(jButtonAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(193, 193, 193))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldBuscarProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(jTextFieldCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxRubro, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(jTextFieldCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(jButtonAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jTextFieldTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButtonAceptar, javax.swing.GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextFieldBuscarProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldBuscarProductoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldBuscarProductoActionPerformed

    private void jTextFieldCantidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldCantidadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldCantidadActionPerformed

    private void jButtonAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAgregarActionPerformed
        int cantidad = Integer.parseInt(this.jTextFieldCantidad.getText());
        int idp = Integer.parseInt(jTextFieldCodigo.getText());
        if (!controlador.isSandwich(jTextFieldCodigo.getText())){
            controlador.agregarProducto(tienda.getTerminal(), cantidad, idp);
        } else{
//            controlador.agregarProducto(tienda.getTerminal(), cantidad, idp);
//            for (int i = 0; i < jTableProductos.getColumnCount()-3; i++) {
//                for (int j = 0; j < cantidad; j++) {                         
//                    boolean condicion = true;
//                    int idA = Creador.getProducto(idp).getAgregado().get(i).getProducto().getId_Producto();
//                    if(jTableProductos.getValueAt(cantidad, i+3).equals(true))
//                        condicion = true;
//                    else
//                        condicion = false;
//                    controlador.agregarAgregado(tienda.getTerminal(), idp, idA, condicion);
//                }
//            }
            ArrayList<Agregado> agregados = new ArrayList();
            agregados = Creador.getProducto(idp).getAgregado();
            for (int i = 0; i < jTableProductos.getColumnCount()-3; i++) {
                for (int j = 0; j < cantidad; j++) {                         
                    boolean condicion = true;                    
                    if(jTableProductos.getValueAt(cantidad - 1, i+3).equals(true))
                        condicion = true;
                    else
                        condicion = false;   
                    agregados.get(i).setIncluido(condicion);                    
                }
            }
            controlador.agregarAgregado(tienda.getTerminal(), idp, agregados);
        }              
        limpiar();
        jButtonAceptar.setVisible(true);


    }//GEN-LAST:event_jButtonAgregarActionPerformed

    private void jTableDetaVentaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableDetaVentaMouseClicked
        // TODO add your handling code here:

    }//GEN-LAST:event_jTableDetaVentaMouseClicked

    private void jButtonAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAceptarActionPerformed
        // TODO mostrar ventana factura y un metodo que agrege la venta y
        controlador.mostrarVistaFactura(tienda);
        this.setVisible(false);
    }//GEN-LAST:event_jButtonAceptarActionPerformed

    private void jTableProductosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableProductosMouseClicked
        // TODO add your handling code here:
        int filaSeleccionada = jTableProductos.getSelectedRow();
//        int idP = Integer.parseInt(jTableProductos.getValueAt(filaSeleccionada, 0).toString());
        jTextFieldBuscarProducto.setText(jTableProductos.getValueAt(filaSeleccionada, 1).toString());
        jTextFieldCodigo.setText(jTableProductos.getValueAt(filaSeleccionada, 0).toString());
    }//GEN-LAST:event_jTableProductosMouseClicked

    private void jComboBoxRubroMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jComboBoxRubroMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxRubroMouseClicked

    private void jTextFieldBuscarProductoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldBuscarProductoKeyReleased

    }//GEN-LAST:event_jTextFieldBuscarProductoKeyReleased

    private void jTextFieldBuscarProductoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldBuscarProductoKeyTyped
        // TODO add your handling code here:
        jTextFieldBuscarProducto.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                trs.setRowFilter(RowFilter.regexFilter(jTextFieldBuscarProducto.getText(), 1));
            }
        });
        trs = new TableRowSorter(modeloTabla2);
        jTableProductos.setRowSorter(trs);
    }//GEN-LAST:event_jTextFieldBuscarProductoKeyTyped

    private void jTextFieldCantidadKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldCantidadKeyTyped
        jTextFieldCantidad.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                if (controlador.disponibilidad(jTextFieldCantidad.getText(), jTextFieldCodigo.getText()) && !controlador.isSandwich(jTextFieldCodigo.getText())) {
                    jButtonAgregar.setVisible(true);
                } else {
                    if (controlador.disponibilidad(jTextFieldCantidad.getText(), jTextFieldCodigo.getText()) && controlador.isSandwich(jTextFieldCodigo.getText())) {
                        mostrarSandwich(Controlador.getProducto(jTextFieldCodigo.getText()), jTextFieldCantidad.getText());
                        jButtonAgregar.setVisible(true);
                    }
                }
            }
        });
    }//GEN-LAST:event_jTextFieldCantidadKeyTyped

    private void jMenuNuevaVentaMenuKeyReleased(javax.swing.event.MenuKeyEvent evt) {//GEN-FIRST:event_jMenuNuevaVentaMenuKeyReleased
        
    }//GEN-LAST:event_jMenuNuevaVentaMenuKeyReleased

    private void jMenuNuevaVentaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuNuevaVentaMouseClicked
        jTableProductos.setVisible(true);        
        jTableDetaVenta.setVisible(true);
        jLabel1.setVisible(true);
        jLabel2.setVisible(true);
        jLabel3.setVisible(true);
        jLabel5.setVisible(true);
        jTextFieldBuscarProducto.setVisible(true);
        jTextFieldCantidad.setVisible(true);
        jButtonAgregar.setVisible(true);
        jButtonAceptar.setVisible(true);
        //jComboBoxRubro.setVisible(true);
        jLabel4.setVisible(true);
        jTextFieldCodigo.setVisible(true);
        jLabel6.setVisible(true);
        jTextFieldTotal.setVisible(true);
        jTableDetaVenta.setVisible(true);
        jTableProductos.setVisible(true);
        jMenuNuevaVenta.setVisible(false);
        controlador.crearVenta(tienda.getTerminal());
    }//GEN-LAST:event_jMenuNuevaVentaMouseClicked

    private void jMenuItem1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuItem1MouseClicked
        //controlador.mostrarFinSesion();
    }//GEN-LAST:event_jMenuItem1MouseClicked

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        FinSesion v1 = new FinSesion();
        v1.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jTextFieldCodigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldCodigoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldCodigoActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(VistaVenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VistaVenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VistaVenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VistaVenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VistaVenta().setVisible(true);
            }
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButtonAceptar;
    private javax.swing.JButton jButtonAgregar;
    private javax.swing.JComboBox<String> jComboBoxRubro;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenu jMenuNuevaVenta;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTableDetaVenta;
    private javax.swing.JTable jTableProductos;
    private javax.swing.JTextField jTextFieldBuscarProducto;
    private javax.swing.JTextField jTextFieldCantidad;
    private javax.swing.JTextField jTextFieldCodigo;
    private javax.swing.JTextField jTextFieldTotal;
    // End of variables declaration//GEN-END:variables

    private void limpiar() {
        jTextFieldBuscarProducto.setText("");
        jTextFieldCantidad.setText("");
        //mostrarProductos(Creador.getCatalogo());
    }

}
