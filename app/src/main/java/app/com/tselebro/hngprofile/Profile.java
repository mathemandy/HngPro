package app.com.tselebro.hngprofile;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import de.cketti.mailto.EmailIntentBuilder;

public class Profile extends AppCompatActivity {


    @BindView(R.id.toolbar)
    Toolbar mToolbar;

    @BindView(R.id.phone_number)
    TextView mPhone;

    @BindView(R.id.github)
    TextView mGithub;

    @BindView(R.id.fab)
    FloatingActionButton fab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        ButterKnife.bind(this);
        setSupportActionBar(mToolbar);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EmailIntentBuilder.from(Profile.this)
                        .to("andyeshiet@gmail.com")
                        .cc("xyluz@ymail.com")
                        .subject("Feedback")
                        .start();

            }
        });

        mPhone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent openDialerIntent = new Intent(Intent.ACTION_DIAL);
                openDialerIntent.setData(Uri.parse("tel:08120088124"));
                startActivity(openDialerIntent);
            }
        });

        mGithub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String profileUrl = "http://github.com/mathemandy";
                openUrlInBrowser(profileUrl, Profile.this);

            }
        });
    }

    public static void openUrlInBrowser(String url, Context context) {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse(url));
        context.startActivity(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_profile, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_share) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
