package com.example.encard02nurbek.di;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;

import com.example.encard02nurbek.data.network.PixabayApi;
import com.example.encard02nurbek.db.CategoryDao;
import com.example.encard02nurbek.db.CategoryDatabase;
import com.example.encard02nurbek.db.WordsDao;
import com.example.encard02nurbek.repository.pixabay.PixabayRepository;
import com.example.encard02nurbek.repository.room.RoomRepository;
import com.google.gson.Gson;


import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.android.qualifiers.ApplicationContext;
import dagger.hilt.components.SingletonComponent;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@InstallIn(SingletonComponent.class)
@Module
public class AppModule {

    @Provides
    public static PixabayApi providerPixabayApi(OkHttpClient client)  {
        return new Retrofit.Builder()
                .baseUrl("http://pixabay.com")
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build()
                .create(PixabayApi.class);
    }

    @Provides
    public static OkHttpClient providerClient() {
        return new OkHttpClient.Builder()
                .addInterceptor(new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
                .build();
    }
    @Provides
    @Singleton
    public static PixabayRepository providerPixabayRepository(PixabayApi api, WordsDao dao) {
        return new PixabayRepository(api, dao);
    }
    @Provides
    @Singleton
    public CategoryDatabase provideDatabase(@ApplicationContext Context context) {
        return Room
                .databaseBuilder(context.getApplicationContext(),
                        CategoryDatabase.class, "DB_NAME")
                .allowMainThreadQueries()
                .build();
    }

    @Provides
    @Singleton
    public CategoryDao providerDao(CategoryDatabase database) {
        return database.getDao();
    }

    @Provides
    public WordsDao providerWordDao(CategoryDatabase database) {
        return database.getWordDao();
    }

    @Provides
    @Singleton
    public static RoomRepository providerRoomRepository(CategoryDao dao, WordsDao wordsDao) {
        return new RoomRepository(dao, wordsDao);
    }
}
