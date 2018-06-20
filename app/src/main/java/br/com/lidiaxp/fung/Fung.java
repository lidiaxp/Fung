package br.com.lidiaxp.fung;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

import static android.support.v4.content.FileProvider.getUriForFile;

public class Fung extends AppCompatActivity {
    public int funcao = 0;
    ImageButton play;
    ImageButton wpp;
    ImageButton messenger;
    ImageButton badum;
    ImageButton beep;
    ImageButton bodybuilder;
    ImageButton dark;
    ImageButton drama;
    ImageButton ehno;
    ImageButton erro;
    ImageButton fodse;
    ImageButton goattack;
    ImageButton isolados;
    ImageButton love;
    ImageButton palmas;
    ImageButton punch;
    ImageButton quaaa;
    ImageButton review;
    ImageButton risos;
    ImageButton risosmal;
    ImageButton suspense;
    ImageButton tambor;
    ImageButton turndown;
    ImageButton vaia;
    ImageButton vaidar;
    ImageButton virou;
    ImageButton whatsay;
    ImageButton fung;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fung);

        play = (ImageButton)findViewById(R.id.play);
        wpp = (ImageButton)findViewById(R.id.wpp);
        messenger = (ImageButton)findViewById(R.id.messenger);
        badum = (ImageButton)findViewById(R.id.badum);
        beep = (ImageButton)findViewById(R.id.beep);
        bodybuilder = (ImageButton)findViewById(R.id.bodybuilder);
        dark = (ImageButton)findViewById(R.id.dark);
        drama = (ImageButton)findViewById(R.id.drama);
        ehno = (ImageButton)findViewById(R.id.ehno);
        erro = (ImageButton)findViewById(R.id.erro);
        fodse = (ImageButton)findViewById(R.id.fodse);
        goattack = (ImageButton)findViewById(R.id.attack);
        isolados = (ImageButton)findViewById(R.id.isolados);
        love = (ImageButton)findViewById(R.id.love);
        palmas = (ImageButton)findViewById(R.id.palmas);
        punch = (ImageButton)findViewById(R.id.punch);
        quaaa = (ImageButton)findViewById(R.id.quaaa);
        review = (ImageButton)findViewById(R.id.review);
        risos = (ImageButton)findViewById(R.id.risos);
        risosmal = (ImageButton)findViewById(R.id.risosmal);
        suspense = (ImageButton)findViewById(R.id.suspense);
        tambor = (ImageButton)findViewById(R.id.tambor);
        turndown = (ImageButton)findViewById(R.id.turndown);
        vaia = (ImageButton)findViewById(R.id.vaia);
        vaidar = (ImageButton)findViewById(R.id.vaidar);
        virou = (ImageButton)findViewById(R.id.virou);
        whatsay = (ImageButton)findViewById(R.id.whatsay);
        fung = (ImageButton)findViewById(R.id.fung);

        funcao = 0;
        play.setBackgroundResource(R.drawable.right);
        final Context ctx = getApplicationContext();

        if(isStoragePermissionGranted()){}else{finish();}

        fung.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                MediaPlayer mp = MediaPlayer.create(Fung.this, R.raw.fung);
                mp.start();
            }
        });

        play.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                funcao = 0;
                play.setBackgroundResource(R.drawable.right);
                wpp.setBackgroundResource(R.drawable.wppp);
                messenger.setBackgroundResource(R.drawable.messengerr);
            }
        });

        wpp.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String state = Environment.getExternalStorageState();
                if (Environment.MEDIA_MOUNTED.equals(state)) {
                    funcao = 1;
                    play.setBackgroundResource(R.drawable.playy);
                    wpp.setBackgroundResource(R.drawable.right);
                    messenger.setBackgroundResource(R.drawable.messengerr);
                }
            }
        });

        messenger.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                funcao = 2;
                play.setBackgroundResource(R.drawable.playy);
                wpp.setBackgroundResource(R.drawable.wppp);
                messenger.setBackgroundResource(R.drawable.right);
            }
        });

        badum.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (funcao == 0) {
                    MediaPlayer mp = MediaPlayer.create(Fung.this, R.raw.badum);
                    mp.start();
                } else if (funcao == 1) {
                    FileOutputStream outputStream;
                    File file = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_RINGTONES), "FUNG/badum.wav"); // assumed target file
                    if (!file.getParentFile().mkdirs() && !file.getParentFile().isDirectory()) { }
                    try {
                        outputStream = new FileOutputStream(file);
                        try {
                            InputStream in = ctx.getResources().openRawResource(R.raw.badum);
                            byte[] buffer = new byte[32768];
                            int read;
                            while ((read = in.read(buffer, 0, buffer.length)) >= 0) {
                                outputStream.write(buffer, 0, read);
                            }
                            in.close();
                        } catch (IOException ex) {
                            ex.printStackTrace();
                        }
                        outputStream.close();
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    Intent shareIntent = new Intent(Intent.ACTION_SEND);
                    Uri uri = Uri.parse(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_RINGTONES) + "/FUNG/badum.wav");
                    shareIntent.setType("audio/m4a");
                    shareIntent.setPackage("com.whatsapp");
                    shareIntent.putExtra(Intent.EXTRA_STREAM, uri);
                    shareIntent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
                    startActivity(shareIntent);
                } else {
                    Intent shareIntent = new Intent(Intent.ACTION_SEND);
                    Uri uri = Uri.parse("android.resource://" + getPackageName() + "/raw/badum");
                    shareIntent.setType("audio/mpeg");
                    shareIntent.setPackage("com.facebook.orca");
                    shareIntent.putExtra(Intent.EXTRA_STREAM, uri);
                    shareIntent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
                    startActivity(shareIntent);
                }
            }
        });

        beep.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if(funcao == 0){
                    MediaPlayer mp = MediaPlayer.create(Fung.this, R.raw.beep);
                    mp.start();
                }else if(funcao == 1){
                    FileOutputStream outputStream;
                    File file = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_RINGTONES), "FUNG/beep.wav"); // assumed target file
                    if (!file.getParentFile().mkdirs() && !file.getParentFile().isDirectory()) { }
                    try {
                        outputStream = new FileOutputStream(file);
                        try {
                            InputStream in = ctx.getResources().openRawResource(R.raw.beep);
                            byte[] buffer = new byte[32768];
                            int read;
                            while ((read = in.read(buffer, 0, buffer.length)) >= 0) {
                                outputStream.write(buffer, 0, read);
                            }
                            in.close();
                        } catch (IOException ex) {
                            ex.printStackTrace();
                        }
                        outputStream.close();
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    Intent shareIntent = new Intent(Intent.ACTION_SEND);
                    Uri uri = Uri.parse(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_RINGTONES) + "/FUNG/beep.wav");
                    shareIntent.setType("audio/m4a");
                    shareIntent.setPackage("com.whatsapp");
                    shareIntent.putExtra(Intent.EXTRA_STREAM, uri);
                    shareIntent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
                    startActivity(shareIntent);
                }else{
                    Intent shareIntent = new Intent(Intent.ACTION_SEND);
                    Uri uri = Uri.parse("android.resource://" + getPackageName() + "/raw/beep");
                    shareIntent.setType("audio/mpeg");
                    shareIntent.setPackage("com.facebook.orca");
                    shareIntent.putExtra(Intent.EXTRA_STREAM, uri);
                    shareIntent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
                    startActivity(shareIntent);
                }
            }
        });

        bodybuilder.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if(funcao == 0){
                    MediaPlayer mp = MediaPlayer.create(Fung.this, R.raw.bodybuilder);
                    mp.start();
                }else if(funcao == 1){
                    FileOutputStream outputStream;
                    File file = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_RINGTONES), "FUNG/bodybuilder.wav"); // assumed target file
                    if (!file.getParentFile().mkdirs() && !file.getParentFile().isDirectory()) { }
                    try {
                        outputStream = new FileOutputStream(file);
                        try {
                            InputStream in = ctx.getResources().openRawResource(R.raw.bodybuilder);
                            byte[] buffer = new byte[32768];
                            int read;
                            while ((read = in.read(buffer, 0, buffer.length)) >= 0) {
                                outputStream.write(buffer, 0, read);
                            }
                            in.close();
                        } catch (IOException ex) {
                            ex.printStackTrace();
                        }
                        outputStream.close();
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    Intent shareIntent = new Intent(Intent.ACTION_SEND);
                    Uri uri = Uri.parse(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_RINGTONES) + "/FUNG/bodybuilder.wav");
                    shareIntent.setType("audio/m4a");
                    shareIntent.setPackage("com.whatsapp");
                    shareIntent.putExtra(Intent.EXTRA_STREAM, uri);
                    shareIntent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
                    startActivity(shareIntent);
                }else{
                    Intent shareIntent = new Intent(Intent.ACTION_SEND);
                    Uri uri = Uri.parse("android.resource://" + getPackageName() + "/raw/bodybuilder");
                    shareIntent.setType("audio/mpeg");
                    shareIntent.setPackage("com.facebook.orca");
                    shareIntent.putExtra(Intent.EXTRA_STREAM, uri);
                    shareIntent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
                    startActivity(shareIntent);
                }
            }
        });

        dark.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if(funcao == 0){
                    MediaPlayer mp = MediaPlayer.create(Fung.this, R.raw.hellodarkness);
                    mp.start();
                }else if(funcao == 1){
                    FileOutputStream outputStream;
                    File file = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_RINGTONES), "FUNG/dark.wav"); // assumed target file
                    if (!file.getParentFile().mkdirs() && !file.getParentFile().isDirectory()) { }
                    try {
                        outputStream = new FileOutputStream(file);
                        try {
                            InputStream in = ctx.getResources().openRawResource(R.raw.hellodarkness);
                            byte[] buffer = new byte[32768];
                            int read;
                            while ((read = in.read(buffer, 0, buffer.length)) >= 0) {
                                outputStream.write(buffer, 0, read);
                            }
                            in.close();
                        } catch (IOException ex) {
                            ex.printStackTrace();
                        }
                        outputStream.close();
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    Intent shareIntent = new Intent(Intent.ACTION_SEND);
                    Uri uri = Uri.parse(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_RINGTONES) + "/FUNG/dark.wav");
                    shareIntent.setType("audio/m4a");
                    shareIntent.setPackage("com.whatsapp");
                    shareIntent.putExtra(Intent.EXTRA_STREAM, uri);
                    shareIntent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
                    startActivity(shareIntent);
                }else{
                    Intent shareIntent = new Intent(Intent.ACTION_SEND);
                    Uri uri = Uri.parse("android.resource://" + getPackageName() + "/raw/hellodarkness");
                    shareIntent.setType("audio/mpeg");
                    shareIntent.setPackage("com.facebook.orca");
                    shareIntent.putExtra(Intent.EXTRA_STREAM, uri);
                    shareIntent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
                    startActivity(shareIntent);
                }
            }
        });

        drama.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if(funcao == 0){
                    MediaPlayer mp = MediaPlayer.create(Fung.this, R.raw.drama);
                    mp.start();
                }else if(funcao == 1){
                    FileOutputStream outputStream;
                    File file = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_RINGTONES), "FUNG/drama.wav"); // assumed target file
                    if (!file.getParentFile().mkdirs() && !file.getParentFile().isDirectory()) { }
                    try {
                        outputStream = new FileOutputStream(file);
                        try {
                            InputStream in = ctx.getResources().openRawResource(R.raw.drama);
                            byte[] buffer = new byte[32768];
                            int read;
                            while ((read = in.read(buffer, 0, buffer.length)) >= 0) {
                                outputStream.write(buffer, 0, read);
                            }
                            in.close();
                        } catch (IOException ex) {
                            ex.printStackTrace();
                        }
                        outputStream.close();
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    Intent shareIntent = new Intent(Intent.ACTION_SEND);
                    Uri uri = Uri.parse(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_RINGTONES) + "/FUNG/drama.wav");
                    shareIntent.setType("audio/m4a");
                    shareIntent.setPackage("com.whatsapp");
                    shareIntent.putExtra(Intent.EXTRA_STREAM, uri);
                    shareIntent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
                    startActivity(shareIntent);
                }else{
                    Intent shareIntent = new Intent(Intent.ACTION_SEND);
                    Uri uri = Uri.parse("android.resource://" + getPackageName() + "/raw/drama");
                    shareIntent.setType("audio/mpeg");
                    shareIntent.setPackage("com.facebook.orca");
                    shareIntent.putExtra(Intent.EXTRA_STREAM, uri);
                    shareIntent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
                    startActivity(shareIntent);
                }
            }
        });

        ehno.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if(funcao == 0){
                    MediaPlayer mp = MediaPlayer.create(Fung.this, R.raw.ehno);
                    mp.start();
                }else if(funcao == 1){
                    FileOutputStream outputStream;
                    File file = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_RINGTONES), "FUNG/ehno.wav"); // assumed target file
                    if (!file.getParentFile().mkdirs() && !file.getParentFile().isDirectory()) { }
                    try {
                        outputStream = new FileOutputStream(file);
                        try {
                            InputStream in = ctx.getResources().openRawResource(R.raw.ehno);
                            byte[] buffer = new byte[32768];
                            int read;
                            while ((read = in.read(buffer, 0, buffer.length)) >= 0) {
                                outputStream.write(buffer, 0, read);
                            }
                            in.close();
                        } catch (IOException ex) {
                            ex.printStackTrace();
                        }
                        outputStream.close();
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    Intent shareIntent = new Intent(Intent.ACTION_SEND);
                    Uri uri = Uri.parse(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_RINGTONES) + "/FUNG/ehno.wav");
                    shareIntent.setType("audio/m4a");
                    shareIntent.setPackage("com.whatsapp");
                    shareIntent.putExtra(Intent.EXTRA_STREAM, uri);
                    shareIntent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
                    startActivity(shareIntent);
                }else{
                    Intent shareIntent = new Intent(Intent.ACTION_SEND);
                    Uri uri = Uri.parse("android.resource://" + getPackageName() + "/raw/ehno");
                    shareIntent.setType("audio/mpeg");
                    shareIntent.setPackage("com.facebook.orca");
                    shareIntent.putExtra(Intent.EXTRA_STREAM, uri);
                    shareIntent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
                    startActivity(shareIntent);
                }
            }
        });

        erro.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if(funcao == 0){
                    MediaPlayer mp = MediaPlayer.create(Fung.this, R.raw.erro);
                    mp.start();
                }else if(funcao == 1){
                    FileOutputStream outputStream;
                    File file = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_RINGTONES), "FUNG/erro.wav"); // assumed target file
                    if (!file.getParentFile().mkdirs() && !file.getParentFile().isDirectory()) { }
                    try {
                        outputStream = new FileOutputStream(file);
                        try {
                            InputStream in = ctx.getResources().openRawResource(R.raw.erro);
                            byte[] buffer = new byte[32768];
                            int read;
                            while ((read = in.read(buffer, 0, buffer.length)) >= 0) {
                                outputStream.write(buffer, 0, read);
                            }
                            in.close();
                        } catch (IOException ex) {
                            ex.printStackTrace();
                        }
                        outputStream.close();
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    Intent shareIntent = new Intent(Intent.ACTION_SEND);
                    Uri uri = Uri.parse(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_RINGTONES) + "/FUNG/erro.wav");
                    shareIntent.setType("audio/m4a");
                    shareIntent.setPackage("com.whatsapp");
                    shareIntent.putExtra(Intent.EXTRA_STREAM, uri);
                    shareIntent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
                    startActivity(shareIntent);
                }else{
                    Intent shareIntent = new Intent(Intent.ACTION_SEND);
                    Uri uri = Uri.parse("android.resource://" + getPackageName() + "/raw/erro");
                    shareIntent.setType("audio/mpeg");
                    shareIntent.setPackage("com.facebook.orca");
                    shareIntent.putExtra(Intent.EXTRA_STREAM, uri);
                    shareIntent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
                    startActivity(shareIntent);
                }
            }
        });

        fodse.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if(funcao == 0){
                    MediaPlayer mp = MediaPlayer.create(Fung.this, R.raw.fodse);
                    mp.start();
                }else if(funcao == 1){
                    FileOutputStream outputStream;
                    File file = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_RINGTONES), "FUNG/fodse.wav"); // assumed target file
                    if (!file.getParentFile().mkdirs() && !file.getParentFile().isDirectory()) { }
                    try {
                        outputStream = new FileOutputStream(file);
                        try {
                            InputStream in = ctx.getResources().openRawResource(R.raw.fodse);
                            byte[] buffer = new byte[32768];
                            int read;
                            while ((read = in.read(buffer, 0, buffer.length)) >= 0) {
                                outputStream.write(buffer, 0, read);
                            }
                            in.close();
                        } catch (IOException ex) {
                            ex.printStackTrace();
                        }
                        outputStream.close();
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    Intent shareIntent = new Intent(Intent.ACTION_SEND);
                    Uri uri = Uri.parse(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_RINGTONES) + "/FUNG/fodse.wav");
                    shareIntent.setType("audio/m4a");
                    shareIntent.setPackage("com.whatsapp");
                    shareIntent.putExtra(Intent.EXTRA_STREAM, uri);
                    shareIntent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
                    startActivity(shareIntent);
                }else{
                    Intent shareIntent = new Intent(Intent.ACTION_SEND);
                    Uri uri = Uri.parse("android.resource://" + getPackageName() + "/raw/fodse");
                    shareIntent.setType("audio/mpeg");
                    shareIntent.setPackage("com.facebook.orca");
                    shareIntent.putExtra(Intent.EXTRA_STREAM, uri);
                    shareIntent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
                    startActivity(shareIntent);
                }
            }
        });

        goattack.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if(funcao == 0){
                    MediaPlayer mp = MediaPlayer.create(Fung.this, R.raw.atacar);
                    mp.start();
                }else if(funcao == 1){
                    FileOutputStream outputStream;
                    File file = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_RINGTONES), "FUNG/goattack.wav"); // assumed target file
                    if (!file.getParentFile().mkdirs() && !file.getParentFile().isDirectory()) { }
                    try {
                        outputStream = new FileOutputStream(file);
                        try {
                            InputStream in = ctx.getResources().openRawResource(R.raw.atacar);
                            byte[] buffer = new byte[32768];
                            int read;
                            while ((read = in.read(buffer, 0, buffer.length)) >= 0) {
                                outputStream.write(buffer, 0, read);
                            }
                            in.close();
                        } catch (IOException ex) {
                            ex.printStackTrace();
                        }
                        outputStream.close();
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    Intent shareIntent = new Intent(Intent.ACTION_SEND);
                    Uri uri = Uri.parse(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_RINGTONES) + "/FUNG/goattack.wav");
                    shareIntent.setType("audio/m4a");
                    shareIntent.setPackage("com.whatsapp");
                    shareIntent.putExtra(Intent.EXTRA_STREAM, uri);
                    shareIntent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
                    startActivity(shareIntent);
                }else{
                    Intent shareIntent = new Intent(Intent.ACTION_SEND);
                    Uri uri = Uri.parse("android.resource://" + getPackageName() + "/raw/atacar");
                    shareIntent.setType("audio/mpeg");
                    shareIntent.setPackage("com.facebook.orca");
                    shareIntent.putExtra(Intent.EXTRA_STREAM, uri);
                    shareIntent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
                    startActivity(shareIntent);
                }
            }
        });

        isolados.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if(funcao == 0){
                    MediaPlayer mp = MediaPlayer.create(Fung.this, R.raw.isolados);
                    mp.start();
                }else if(funcao == 1){
                    FileOutputStream outputStream;
                    File file = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_RINGTONES), "FUNG/isoladosp.wav"); // assumed target file
                    if (!file.getParentFile().mkdirs() && !file.getParentFile().isDirectory()) { }
                    try {
                        outputStream = new FileOutputStream(file);
                        try {
                            InputStream in = ctx.getResources().openRawResource(R.raw.isolados);
                            byte[] buffer = new byte[32768];
                            int read;
                            while ((read = in.read(buffer, 0, buffer.length)) >= 0) {
                                outputStream.write(buffer, 0, read);
                            }
                            in.close();
                        } catch (IOException ex) {
                            ex.printStackTrace();
                        }
                        outputStream.close();
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    Intent shareIntent = new Intent(Intent.ACTION_SEND);
                    Uri uri = Uri.parse(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_RINGTONES) + "/FUNG/isolados.wav");
                    shareIntent.setType("audio/m4a");
                    shareIntent.setPackage("com.whatsapp");
                    shareIntent.putExtra(Intent.EXTRA_STREAM, uri);
                    shareIntent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
                    startActivity(shareIntent);
                }else{
                    Intent shareIntent = new Intent(Intent.ACTION_SEND);
                    Uri uri = Uri.parse("android.resource://" + getPackageName() + "/raw/isolados");
                    shareIntent.setType("audio/mpeg");
                    shareIntent.setPackage("com.facebook.orca");
                    shareIntent.putExtra(Intent.EXTRA_STREAM, uri);
                    shareIntent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
                    startActivity(shareIntent);
                }
            }
        });

        love.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if(funcao == 0){
                    MediaPlayer mp = MediaPlayer.create(Fung.this, R.raw.love);
                    mp.start();
                }else if(funcao == 1){
                    FileOutputStream outputStream;
                    File file = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_RINGTONES), "FUNG/love.wav"); // assumed target file
                    if (!file.getParentFile().mkdirs() && !file.getParentFile().isDirectory()) { }
                    try {
                        outputStream = new FileOutputStream(file);
                        try {
                            InputStream in = ctx.getResources().openRawResource(R.raw.love);
                            byte[] buffer = new byte[32768];
                            int read;
                            while ((read = in.read(buffer, 0, buffer.length)) >= 0) {
                                outputStream.write(buffer, 0, read);
                            }
                            in.close();
                        } catch (IOException ex) {
                            ex.printStackTrace();
                        }
                        outputStream.close();
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    Intent shareIntent = new Intent(Intent.ACTION_SEND);
                    Uri uri = Uri.parse(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_RINGTONES) + "/FUNG/love.wav");
                    shareIntent.setType("audio/m4a");
                    shareIntent.setPackage("com.whatsapp");
                    shareIntent.putExtra(Intent.EXTRA_STREAM, uri);
                    shareIntent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
                    startActivity(shareIntent);
                }else{
                    Intent shareIntent = new Intent(Intent.ACTION_SEND);
                    Uri uri = Uri.parse("android.resource://" + getPackageName() + "/raw/love");
                    shareIntent.setType("audio/mpeg");
                    shareIntent.setPackage("com.facebook.orca");
                    shareIntent.putExtra(Intent.EXTRA_STREAM, uri);
                    shareIntent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
                    startActivity(shareIntent);
                }
            }
        });

        palmas.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if(funcao == 0){
                    MediaPlayer mp = MediaPlayer.create(Fung.this, R.raw.palmas);
                    mp.start();
                }else if(funcao == 1){
                    FileOutputStream outputStream;
                    File file = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_RINGTONES), "FUNG/palmas.wav"); // assumed target file
                    if (!file.getParentFile().mkdirs() && !file.getParentFile().isDirectory()) { }
                    try {
                        outputStream = new FileOutputStream(file);
                        try {
                            InputStream in = ctx.getResources().openRawResource(R.raw.palmas);
                            byte[] buffer = new byte[32768];
                            int read;
                            while ((read = in.read(buffer, 0, buffer.length)) >= 0) {
                                outputStream.write(buffer, 0, read);
                            }
                            in.close();
                        } catch (IOException ex) {
                            ex.printStackTrace();
                        }
                        outputStream.close();
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    Intent shareIntent = new Intent(Intent.ACTION_SEND);
                    Uri uri = Uri.parse(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_RINGTONES) + "/FUNG/palmas.wav");
                    shareIntent.setType("audio/m4a");
                    shareIntent.setPackage("com.whatsapp");
                    shareIntent.putExtra(Intent.EXTRA_STREAM, uri);
                    shareIntent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
                    startActivity(shareIntent);
                }else{
                    Intent shareIntent = new Intent(Intent.ACTION_SEND);
                    Uri uri = Uri.parse("android.resource://" + getPackageName() + "/raw/palmas");
                    shareIntent.setType("audio/mpeg");
                    shareIntent.setPackage("com.facebook.orca");
                    shareIntent.putExtra(Intent.EXTRA_STREAM, uri);
                    shareIntent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
                    startActivity(shareIntent);
                }
            }
        });

        punch.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if(funcao == 0){
                    MediaPlayer mp = MediaPlayer.create(Fung.this, R.raw.punch);
                    mp.start();
                }else if(funcao == 1){
                    FileOutputStream outputStream;
                    File file = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_RINGTONES), "FUNG/punch.wav"); // assumed target file
                    if (!file.getParentFile().mkdirs() && !file.getParentFile().isDirectory()) { }
                    try {
                        outputStream = new FileOutputStream(file);
                        try {
                            InputStream in = ctx.getResources().openRawResource(R.raw.punch);
                            byte[] buffer = new byte[32768];
                            int read;
                            while ((read = in.read(buffer, 0, buffer.length)) >= 0) {
                                outputStream.write(buffer, 0, read);
                            }
                            in.close();
                        } catch (IOException ex) {
                            ex.printStackTrace();
                        }
                        outputStream.close();
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    Intent shareIntent = new Intent(Intent.ACTION_SEND);
                    Uri uri = Uri.parse(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_RINGTONES) + "/FUNG/punch.wav");
                    shareIntent.setType("audio/m4a");
                    shareIntent.setPackage("com.whatsapp");
                    shareIntent.putExtra(Intent.EXTRA_STREAM, uri);
                    shareIntent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
                    startActivity(shareIntent);
                }else{
                    Intent shareIntent = new Intent(Intent.ACTION_SEND);
                    Uri uri = Uri.parse("android.resource://" + getPackageName() + "/raw/punch");
                    shareIntent.setType("audio/mpeg");
                    shareIntent.setPackage("com.facebook.orca");
                    shareIntent.putExtra(Intent.EXTRA_STREAM, uri);
                    shareIntent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
                    startActivity(shareIntent);
                }
            }
        });

        quaaa.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if(funcao == 0){
                    MediaPlayer mp = MediaPlayer.create(Fung.this, R.raw.quaaa);
                    mp.start();
                }else if(funcao == 1){
                    FileOutputStream outputStream;
                    File file = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_RINGTONES), "FUNG/quaaa.wav"); // assumed target file
                    if (!file.getParentFile().mkdirs() && !file.getParentFile().isDirectory()) { }
                    try {
                        outputStream = new FileOutputStream(file);
                        try {
                            InputStream in = ctx.getResources().openRawResource(R.raw.quaaa);
                            byte[] buffer = new byte[32768];
                            int read;
                            while ((read = in.read(buffer, 0, buffer.length)) >= 0) {
                                outputStream.write(buffer, 0, read);
                            }
                            in.close();
                        } catch (IOException ex) {
                            ex.printStackTrace();
                        }
                        outputStream.close();
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    Intent shareIntent = new Intent(Intent.ACTION_SEND);
                    Uri uri = Uri.parse(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_RINGTONES) + "/FUNG/quaaa.wav");
                    shareIntent.setType("audio/m4a");
                    shareIntent.setPackage("com.whatsapp");
                    shareIntent.putExtra(Intent.EXTRA_STREAM, uri);
                    shareIntent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
                    startActivity(shareIntent);
                }else{
                    Intent shareIntent = new Intent(Intent.ACTION_SEND);
                    Uri uri = Uri.parse("android.resource://" + getPackageName() + "/raw/quaaa");
                    shareIntent.setType("audio/mpeg");
                    shareIntent.setPackage("com.facebook.orca");
                    shareIntent.putExtra(Intent.EXTRA_STREAM, uri);
                    shareIntent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
                    startActivity(shareIntent);
                }
            }
        });

        review.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if(funcao == 0){
                    MediaPlayer mp = MediaPlayer.create(Fung.this, R.raw.review);
                    mp.start();
                }else if(funcao == 1){
                    FileOutputStream outputStream;
                    File file = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_RINGTONES), "FUNG/review.wav"); // assumed target file
                    if (!file.getParentFile().mkdirs() && !file.getParentFile().isDirectory()) { }
                    try {
                        outputStream = new FileOutputStream(file);
                        try {
                            InputStream in = ctx.getResources().openRawResource(R.raw.review);
                            byte[] buffer = new byte[32768];
                            int read;
                            while ((read = in.read(buffer, 0, buffer.length)) >= 0) {
                                outputStream.write(buffer, 0, read);
                            }
                            in.close();
                        } catch (IOException ex) {
                            ex.printStackTrace();
                        }
                        outputStream.close();
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    Intent shareIntent = new Intent(Intent.ACTION_SEND);
                    Uri uri = Uri.parse(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_RINGTONES) + "/FUNG/review.wav");
                    shareIntent.setType("audio/m4a");
                    shareIntent.setPackage("com.whatsapp");
                    shareIntent.putExtra(Intent.EXTRA_STREAM, uri);
                    shareIntent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
                    startActivity(shareIntent);
                }else{
                    Intent shareIntent = new Intent(Intent.ACTION_SEND);
                    Uri uri = Uri.parse("android.resource://" + getPackageName() + "/raw/review");
                    shareIntent.setType("audio/mpeg");
                    shareIntent.setPackage("com.facebook.orca");
                    shareIntent.putExtra(Intent.EXTRA_STREAM, uri);
                    shareIntent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
                    startActivity(shareIntent);
                }
            }
        });

        risos.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if(funcao == 0){
                    MediaPlayer mp = MediaPlayer.create(Fung.this, R.raw.risada);
                    mp.start();
                }else if(funcao == 1){
                    FileOutputStream outputStream;
                    File file = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_RINGTONES), "FUNG/risada.wav"); // assumed target file
                    if (!file.getParentFile().mkdirs() && !file.getParentFile().isDirectory()) { }
                    try {
                        outputStream = new FileOutputStream(file);
                        try {
                            InputStream in = ctx.getResources().openRawResource(R.raw.risada);
                            byte[] buffer = new byte[32768];
                            int read;
                            while ((read = in.read(buffer, 0, buffer.length)) >= 0) {
                                outputStream.write(buffer, 0, read);
                            }
                            in.close();
                        } catch (IOException ex) {
                            ex.printStackTrace();
                        }
                        outputStream.close();
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    Intent shareIntent = new Intent(Intent.ACTION_SEND);
                    Uri uri = Uri.parse(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_RINGTONES) + "/FUNG/risada.wav");
                    shareIntent.setType("audio/m4a");
                    shareIntent.setPackage("com.whatsapp");
                    shareIntent.putExtra(Intent.EXTRA_STREAM, uri);
                    shareIntent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
                    startActivity(shareIntent);
                }else{
                    Intent shareIntent = new Intent(Intent.ACTION_SEND);
                    Uri uri = Uri.parse("android.resource://" + getPackageName() + "/raw/risada");
                    shareIntent.setType("audio/mpeg");
                    shareIntent.setPackage("com.facebook.orca");
                    shareIntent.putExtra(Intent.EXTRA_STREAM, uri);
                    shareIntent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
                    startActivity(shareIntent);
                }
            }
        });

        risosmal.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if(funcao == 0){
                    MediaPlayer mp = MediaPlayer.create(Fung.this, R.raw.risadamal);
                    mp.start();
                }else if(funcao == 1){
                    FileOutputStream outputStream;
                    File file = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_RINGTONES), "FUNG/risada_mal.wav"); // assumed target file
                    if (!file.getParentFile().mkdirs() && !file.getParentFile().isDirectory()) { }
                    try {
                        outputStream = new FileOutputStream(file);
                        try {
                            InputStream in = ctx.getResources().openRawResource(R.raw.risadamal);
                            byte[] buffer = new byte[32768];
                            int read;
                            while ((read = in.read(buffer, 0, buffer.length)) >= 0) {
                                outputStream.write(buffer, 0, read);
                            }
                            in.close();
                        } catch (IOException ex) {
                            ex.printStackTrace();
                        }
                        outputStream.close();
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    Intent shareIntent = new Intent(Intent.ACTION_SEND);
                    Uri uri = Uri.parse(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_RINGTONES) + "/FUNG/risada_mal.wav");
                    shareIntent.setType("audio/m4a");
                    shareIntent.setPackage("com.whatsapp");
                    shareIntent.putExtra(Intent.EXTRA_STREAM, uri);
                    shareIntent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
                    startActivity(shareIntent);
                }else{
                    Intent shareIntent = new Intent(Intent.ACTION_SEND);
                    Uri uri = Uri.parse("android.resource://" + getPackageName() + "/raw/risadamal");
                    shareIntent.setType("audio/mpeg");
                    shareIntent.setPackage("com.facebook.orca");
                    shareIntent.putExtra(Intent.EXTRA_STREAM, uri);
                    shareIntent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
                    startActivity(shareIntent);
                }
            }
        });

        suspense.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if(funcao == 0){
                    MediaPlayer mp = MediaPlayer.create(Fung.this, R.raw.suspense);
                    mp.start();
                }else if(funcao == 1){
                    FileOutputStream outputStream;
                    File file = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_RINGTONES), "FUNG/suspense.wav"); // assumed target file
                    if (!file.getParentFile().mkdirs() && !file.getParentFile().isDirectory()) { }
                    try {
                        outputStream = new FileOutputStream(file);
                        try {
                            InputStream in = ctx.getResources().openRawResource(R.raw.suspense);
                            byte[] buffer = new byte[32768];
                            int read;
                            while ((read = in.read(buffer, 0, buffer.length)) >= 0) {
                                outputStream.write(buffer, 0, read);
                            }
                            in.close();
                        } catch (IOException ex) {
                            ex.printStackTrace();
                        }
                        outputStream.close();
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    Intent shareIntent = new Intent(Intent.ACTION_SEND);
                    Uri uri = Uri.parse(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_RINGTONES) + "/FUNG/suspense.wav");
                    shareIntent.setType("audio/m4a");
                    shareIntent.setPackage("com.whatsapp");
                    shareIntent.putExtra(Intent.EXTRA_STREAM, uri);
                    shareIntent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
                    startActivity(shareIntent);
                }else{
                    Intent shareIntent = new Intent(Intent.ACTION_SEND);
                    Uri uri = Uri.parse("android.resource://" + getPackageName() + "/raw/suspense");
                    shareIntent.setType("audio/mpeg");
                    shareIntent.setPackage("com.facebook.orca");
                    shareIntent.putExtra(Intent.EXTRA_STREAM, uri);
                    shareIntent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
                    startActivity(shareIntent);
                }
            }
        });

        tambor.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if(funcao == 0){
                    MediaPlayer mp = MediaPlayer.create(Fung.this, R.raw.tambor);
                    mp.start();
                }else if(funcao == 1){
                    FileOutputStream outputStream;
                    File file = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_RINGTONES), "FUNG/tambor.wav"); // assumed target file
                    if (!file.getParentFile().mkdirs() && !file.getParentFile().isDirectory()) { }
                    try {
                        outputStream = new FileOutputStream(file);
                        try {
                            InputStream in = ctx.getResources().openRawResource(R.raw.tambor);
                            byte[] buffer = new byte[32768];
                            int read;
                            while ((read = in.read(buffer, 0, buffer.length)) >= 0) {
                                outputStream.write(buffer, 0, read);
                            }
                            in.close();
                        } catch (IOException ex) {
                            ex.printStackTrace();
                        }
                        outputStream.close();
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    Intent shareIntent = new Intent(Intent.ACTION_SEND);
                    Uri uri = Uri.parse(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_RINGTONES) + "/FUNG/tambor.wav");
                    shareIntent.setType("audio/m4a");
                    shareIntent.setPackage("com.whatsapp");
                    shareIntent.putExtra(Intent.EXTRA_STREAM, uri);
                    shareIntent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
                    startActivity(shareIntent);
                }else{
                    Intent shareIntent = new Intent(Intent.ACTION_SEND);
                    Uri uri = Uri.parse("android.resource://" + getPackageName() + "/raw/tambor");
                    shareIntent.setType("audio/mpeg");
                    shareIntent.setPackage("com.facebook.orca");
                    shareIntent.putExtra(Intent.EXTRA_STREAM, uri);
                    shareIntent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
                    startActivity(shareIntent);
                }
            }
        });

        turndown.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if(funcao == 0){
                    MediaPlayer mp = MediaPlayer.create(Fung.this, R.raw.turndown);
                    mp.start();
                }else if(funcao == 1){
                    FileOutputStream outputStream;
                    File file = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_RINGTONES), "FUNG/turndown.wav"); // assumed target file
                    if (!file.getParentFile().mkdirs() && !file.getParentFile().isDirectory()) { }
                    try {
                        outputStream = new FileOutputStream(file);
                        try {
                            InputStream in = ctx.getResources().openRawResource(R.raw.turndown);
                            byte[] buffer = new byte[32768];
                            int read;
                            while ((read = in.read(buffer, 0, buffer.length)) >= 0) {
                                outputStream.write(buffer, 0, read);
                            }
                            in.close();
                        } catch (IOException ex) {
                            ex.printStackTrace();
                        }
                        outputStream.close();
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    Intent shareIntent = new Intent(Intent.ACTION_SEND);
                    Uri uri = Uri.parse(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_RINGTONES) + "/FUNG/turndown.wav");
                    shareIntent.setType("audio/m4a");
                    shareIntent.setPackage("com.whatsapp");
                    shareIntent.putExtra(Intent.EXTRA_STREAM, uri);
                    shareIntent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
                    startActivity(shareIntent);
                }else{
                    Intent shareIntent = new Intent(Intent.ACTION_SEND);
                    Uri uri = Uri.parse("android.resource://" + getPackageName() + "/raw/turndown");
                    shareIntent.setType("audio/mpeg");
                    shareIntent.setPackage("com.facebook.orca");
                    shareIntent.putExtra(Intent.EXTRA_STREAM, uri);
                    shareIntent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
                    startActivity(shareIntent);
                }
            }
        });

        vaia.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if(funcao == 0){
                    MediaPlayer mp = MediaPlayer.create(Fung.this, R.raw.vaia);
                    mp.start();
                }else if(funcao == 1){
                    FileOutputStream outputStream;
                    File file = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_RINGTONES), "FUNG/vaia.wav"); // assumed target file
                    if (!file.getParentFile().mkdirs() && !file.getParentFile().isDirectory()) { }
                    try {
                        outputStream = new FileOutputStream(file);
                        try {
                            InputStream in = ctx.getResources().openRawResource(R.raw.vaia);
                            byte[] buffer = new byte[32768];
                            int read;
                            while ((read = in.read(buffer, 0, buffer.length)) >= 0) {
                                outputStream.write(buffer, 0, read);
                            }
                            in.close();
                        } catch (IOException ex) {
                            ex.printStackTrace();
                        }
                        outputStream.close();
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    Intent shareIntent = new Intent(Intent.ACTION_SEND);
                    Uri uri = Uri.parse(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_RINGTONES) + "/FUNG/vaia.wav");
                    shareIntent.setType("audio/m4a");
                    shareIntent.setPackage("com.whatsapp");
                    shareIntent.putExtra(Intent.EXTRA_STREAM, uri);
                    shareIntent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
                    startActivity(shareIntent);
                }else{
                    Intent shareIntent = new Intent(Intent.ACTION_SEND);
                    Uri uri = Uri.parse("android.resource://" + getPackageName() + "/raw/vaia");
                    shareIntent.setType("audio/mpeg");
                    shareIntent.setPackage("com.facebook.orca");
                    shareIntent.putExtra(Intent.EXTRA_STREAM, uri);
                    shareIntent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
                    startActivity(shareIntent);
                }
            }
        });

        vaidar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if(funcao == 0){
                    MediaPlayer mp = MediaPlayer.create(Fung.this, R.raw.vaidar);
                    mp.start();
                }else if(funcao == 1){
                    FileOutputStream outputStream;
                    File file = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_RINGTONES), "FUNG/vaidar.wav"); // assumed target file
                    if (!file.getParentFile().mkdirs() && !file.getParentFile().isDirectory()) { }
                    try {
                        outputStream = new FileOutputStream(file);
                        try {
                            InputStream in = ctx.getResources().openRawResource(R.raw.vaidar);
                            byte[] buffer = new byte[32768];
                            int read;
                            while ((read = in.read(buffer, 0, buffer.length)) >= 0) {
                                outputStream.write(buffer, 0, read);
                            }
                            in.close();
                        } catch (IOException ex) {
                            ex.printStackTrace();
                        }
                        outputStream.close();
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    Intent shareIntent = new Intent(Intent.ACTION_SEND);
                    Uri uri = Uri.parse(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_RINGTONES) + "/FUNG/vaidar.wav");
                    shareIntent.setType("audio/m4a");
                    shareIntent.setPackage("com.whatsapp");
                    shareIntent.putExtra(Intent.EXTRA_STREAM, uri);
                    shareIntent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
                    startActivity(shareIntent);
                }else{
                    Intent shareIntent = new Intent(Intent.ACTION_SEND);
                    Uri uri = Uri.parse("android.resource://" + getPackageName() + "/raw/vaidar");
                    shareIntent.setType("audio/mpeg");
                    shareIntent.setPackage("com.facebook.orca");
                    shareIntent.putExtra(Intent.EXTRA_STREAM, uri);
                    shareIntent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
                    startActivity(shareIntent);
                }
            }
        });

        virou.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if(funcao == 0){
                    MediaPlayer mp = MediaPlayer.create(Fung.this, R.raw.jogovirou);
                    mp.start();
                }else if(funcao == 1){
                    FileOutputStream outputStream;
                    File file = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_RINGTONES), "FUNG/virou.wav"); // assumed target file
                    if (!file.getParentFile().mkdirs() && !file.getParentFile().isDirectory()) { }
                    try {
                        outputStream = new FileOutputStream(file);
                        try {
                            InputStream in = ctx.getResources().openRawResource(R.raw.jogovirou);
                            byte[] buffer = new byte[32768];
                            int read;
                            while ((read = in.read(buffer, 0, buffer.length)) >= 0) {
                                outputStream.write(buffer, 0, read);
                            }
                            in.close();
                        } catch (IOException ex) {
                            ex.printStackTrace();
                        }
                        outputStream.close();
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    Intent shareIntent = new Intent(Intent.ACTION_SEND);
                    Uri uri = Uri.parse(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_RINGTONES) + "/FUNG/virou.wav");
                    shareIntent.setType("audio/m4a");
                    shareIntent.setPackage("com.whatsapp");
                    shareIntent.putExtra(Intent.EXTRA_STREAM, uri);
                    shareIntent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
                    startActivity(shareIntent);
                }else{
                    Intent shareIntent = new Intent(Intent.ACTION_SEND);
                    Uri uri = Uri.parse("android.resource://" + getPackageName() + "/raw/jogovirou");
                    shareIntent.setType("audio/mpeg");
                    shareIntent.setPackage("com.facebook.orca");
                    shareIntent.putExtra(Intent.EXTRA_STREAM, uri);
                    shareIntent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
                    startActivity(shareIntent);
                }
            }
        });

        whatsay.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if(funcao == 0){
                    MediaPlayer mp = MediaPlayer.create(Fung.this, R.raw.whatsay);
                    mp.start();
                }else if(funcao == 1){
                    FileOutputStream outputStream;
                    File file = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_RINGTONES), "FUNG/whatsay.wav"); // assumed target file
                    if (!file.getParentFile().mkdirs() && !file.getParentFile().isDirectory()) { }
                    try {
                        outputStream = new FileOutputStream(file);
                        try {
                            InputStream in = ctx.getResources().openRawResource(R.raw.whatsay);
                            byte[] buffer = new byte[32768];
                            int read;
                            while ((read = in.read(buffer, 0, buffer.length)) >= 0) {
                                outputStream.write(buffer, 0, read);
                            }
                            in.close();
                        } catch (IOException ex) {
                            ex.printStackTrace();
                        }
                        outputStream.close();
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    Intent shareIntent = new Intent(Intent.ACTION_SEND);
                    Uri uri = Uri.parse(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_RINGTONES) + "/FUNG/whatsay.wav");
                    shareIntent.setType("audio/m4a");
                    shareIntent.setPackage("com.whatsapp");
                    shareIntent.putExtra(Intent.EXTRA_STREAM, uri);
                    shareIntent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
                    startActivity(shareIntent);
                }else{
                    Intent shareIntent = new Intent(Intent.ACTION_SEND);
                    Uri uri = Uri.parse("android.resource://" + getPackageName() + "/raw/whatsay");
                    shareIntent.setType("audio/mpeg");
                    shareIntent.setPackage("com.facebook.orca");
                    shareIntent.putExtra(Intent.EXTRA_STREAM, uri);
                    shareIntent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
                    startActivity(shareIntent);
                }
            }
        });
    }

    public  boolean isStoragePermissionGranted() {
        if (Build.VERSION.SDK_INT >= 23) {
            if (checkSelfPermission(android.Manifest.permission.WRITE_EXTERNAL_STORAGE)
                    == PackageManager.PERMISSION_GRANTED) {
                return true;
            } else {
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 1);
                return false;
            }
        }
        else {
            return true;
        }
    }
}

