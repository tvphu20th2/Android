package phurua.student.c3_qlsach;

    import java.util.ArrayList;
    import java.util.Calendar;
    import java.util.Date;

    import android.os.Bundle;
    import android.app.Activity;
    import android.app.DatePickerDialog;
    import android.app.DatePickerDialog.OnDateSetListener;
    import android.app.ListActivity;
    import android.content.ContentValues;
    import android.database.Cursor;
    import android.database.sqlite.SQLiteDatabase;
    import android.view.Menu;
    import android.view.View;
    import android.view.View.OnClickListener;
    import android.widget.ArrayAdapter;
    import android.widget.Button;
    import android.widget.DatePicker;
    import android.widget.EditText;
    import android.widget.ListView;
    import android.widget.Spinner;
    import android.widget.SpinnerAdapter;
    import android.widget.Toast;

public class QuanLySachActivity extends Activity {

    Spinner dstacgia;
    EditText etTenSach;
    EditText etNgayXuatBan;
    SQLiteDatabase database;
    ArrayList<TacGia> arrayTacGia;
    ArrayList<Sach> arraySach;
    DSSachArrayAdapter arrayAdapterSach;
    ListView lvDSSach;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quan_ly_sach);

        etTenSach = findViewById(R.id.editTenSach);
        etNgayXuatBan = findViewById(R.id.editDateNgayPhatHanh);
         etNgayXuatBan.setEnabled(false);
         lvDSSach =  findViewById(R.id.lvSach);
            try {
                database = openOrCreateDatabase("quanlysach.db", MODE_PRIVATE, null);
            } catch (Exception ex) {

            }

         arrayTacGia = new ArrayList<TacGia>();
         napDanhSachTacGia();
        // String arr[]={"abc","123"};
         dstacgia = findViewById(R.id.spinnerTacGia);
         ArrayAdapter<TacGia> adapter = new ArrayAdapter<TacGia>(this,
                 android.R.layout.simple_spinner_item, arrayTacGia);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
         dstacgia.setAdapter(adapter);
         arraySach = new ArrayList<Sach>();
         napDanhSachSach();
         arrayAdapterSach = new DSSachArrayAdapter(this, arraySach);
         lvDSSach.setAdapter(arrayAdapterSach);

         Button buttonNgayXB = findViewById(R.id.buttonChonNgay);
         buttonNgayXB.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 DatePickerDialog.OnDateSetListener callback = new DatePickerDialog.OnDateSetListener(){
                     public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                         // TODO Auto-generated method stub
                        // findViewById(R.id.editDateNgayPhatHanh).set;
                          }

                 };
                 Calendar now = Calendar.getInstance();
                 DatePickerDialog pic = new DatePickerDialog(
                         QuanLySachActivity.this, callback, now.get(Calendar.YEAR),
                         now.get(Calendar.MONTH), now.get(Calendar.DAY_OF_MONTH));
                 pic.setTitle("Chọn ngày xuất bản");
                  pic.show();
                 }
            });
        Button buttonThemSach = (Button) findViewById(R.id.buttonThemSach);
        buttonThemSach.setOnClickListener(new View.OnClickListener() {

            @Override
             public void onClick(View arg0) {
                if (dstacgia.getSelectedItem() == null)
                     LopChucNang.showMessage(QuanLySachActivity.this,
                         "Bạn phải chọn tác giả", "Lỗi");
                else if (etTenSach.getText().toString().trim().equals(""))
                        LopChucNang.showMessage(QuanLySachActivity.this,
                         "Bạn phải nhập tên sách", "Lỗi");
                 else if (etNgayXuatBan.getText().toString().trim().equals(""))
                    LopChucNang.showMessage(QuanLySachActivity.this,
                         "Bạn phải chọn ngày xuất bản", "Lỗi");
                 else {
                    ContentValues values = new ContentValues();
                    // dstacgia.getSelectedItemPosition()
                     values.put("matacgia",
                             ((TacGia) dstacgia.getSelectedItem()).getMaTG());
                    values.put("tensach", etTenSach.getText().toString());
                    values.put("ngayxuatban", etNgayXuatBan.getText()
                             .toString());
                     String msg;
                     if (database.insert("sach", null, values) == -1)
                         msg = "Thêm không thành công. Trùng khóa chính";
                     else
                     msg = "Thêm sách thành công";

                     Toast.makeText(QuanLySachActivity.this, msg, Toast.LENGTH_LONG).show();
                    napDanhSachSach();
                     arrayAdapterSach.notifyDataSetChanged();
                     xoaTrang();
                     }
                 }
            });
         }
        private void xoaTrang() {
            etTenSach.setText(null);
            etNgayXuatBan.setText(null);

         }

         @Override
        protected void onStop() {
             super.onStop();
             database.close();
        }
        private void napDanhSachTacGia() {
        arrayTacGia.clear();
        Cursor cursor = database.query("tacgia", null, null, null, null, null,
                 null);
        TacGia tg;
        if (cursor.moveToFirst()) {
             do {

                 tg = new TacGia(cursor.getString(0), cursor.getString(1));

                 arrayTacGia.add(tg);
                 } while (cursor.moveToNext());

             }
         cursor.close();
         }

         private void napDanhSachSach() {
             arraySach.clear();
             Cursor cursor = database.query("sach", null, null, null, null, null, null);
             Sach sach;
            if (cursor.moveToFirst()) {
                do {
                     sach = new Sach(cursor.getString(0), cursor.getString(1), cursor.getString(2));

                     arraySach.add(sach);
                    } while (cursor.moveToNext());

                 }
             cursor.close();
            }
}