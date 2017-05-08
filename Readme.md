# NewtonApp
NewtonApp merupakan proyek pengembangan Aplikasi Android dengan menggunakan RecyclerView, Retrofit 2, dan Retrofit Gson Converter. RecyclerView digunakan untuk membuat tampilan aplikasi, Retrofit 2 digunakan untuk mengubah HTTP API ke dalam Java Interface, sedangkan Interface Gson Converter digunakan untuk parse JSON ke jenis data lain, seperti String dan Integer. Info lebih lanjut dapat dibaca pada laman resmi berikut ini: http://square.github.io/retrofit/ dan https://developer.android.com/reference/android/support/v7/widget/RecyclerView.html.

NewtonApp digunakan untuk mengambil dan menampilkan data dari https://thingspeak.com/.

# Menambahkan Library RecyclerView dan Retrofit
Pustaka dapat ditambahkan dengan mengedit dan menambahkan kode berikut ke dalam file build.gradle pada bagian _dependencies_
  >    compile 'com.squareup.retrofit2:retrofit:2.0.2'

  >    compile 'com.squareup.retrofit2:converter-gson:2.0.2'

  >    compile 'com.google.code.gson:gson:2.6.2'

  >    compile 'com.android.support:recyclerview-v7:25.3.1'

  >    compile 'com.android.support:cardview-v7:25.3.1'

# Menambahkan Data yang Akan ditampilkan
Buka app>res>layout dan buka file list_item.xml. Tambahkan baris kode
  >          <TextView
  >          android:id="@+id/TextView5"
  >          android:layout_width="wrap_content"
  >          android:layout_height="wrap_content" />
sebelum baris kode
  > LinearLayout
  
dan ganti TextView5 dengan ID lain sesuai dengan jumlah data yang diinginkan. Kemudian buka folder Java>com.dirakit.newtonapp dan buka file Feed tambahkan baris kode

  >   @SerializedName("fieldXX")
  
  >   @Expose
  
  >   private String fieldXX;
  
Ganti XX dengan nomor field yang digunakan. Kemudian klik kanan dan pilih Generate, kemudian pilih Setter.

Buka file DataAdapter, kemudian bagian class ViewHolder pada baris 
> private TextView textView, textView2, textView3, textView4, textView5, noData, ID_TextView1;

tambahkan nama ID TextView yang digunakanpda bagian belakang sebelum tanda (;). Kemudian tambahkan 
> XXX = (TextView) view.findViewById(R.id.XXX);

di bawah super(view);
dan ganti dengan XXX dengan ID TextView yang sesuai.

Pada bagian onBindViewHolder, tambahkan baris
>  viewHolder.ID_TextView.setText("a  = " + feeds.get(position).getFieldX());

sebelum baris 
> viewHolder.noData.setText("Data " + (position+1));

dan ganti ID_TextView dengan ID TextView yang sesuai dan getFieldX dengan field yang digunakan.

# Mengganti api_key dan results
Buka folder res>values dan buka file strings.xml. Kemudian pada https://api.thingspeak.com/channels/XXXXXXX/, ganti XXXXX dengan Chanel ID yang digunakan. Ganti juga apikey dengan api_key read yang akan digunakan.
