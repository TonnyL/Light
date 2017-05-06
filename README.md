# Light

<div align="center">
	<img src="./images/ic_launcher.png" width="128">
</div>

The usual Snackbar, but elegant. Inspired by [Toasty](https://github.com/GrenderG/Toasty).

## Attention
**Not finished yet!**

## Screenshots

Success | Info | Warning
---- | ---- | ----
![Success](./images/success.png) | ![Info](./images/info.png) | ![Warning](./images/warning.png)
**Error** | **Normal** | **Custom**
![Error](./images/error.png) | ![Normal](./images/normal.png) | ![Custom](./images/custom.png)

## Usage

Each method always returns a `Snackbar` object, so you can customize the Snackbar much more. **DO NOT FORGET TO CALL THE `show()` METHOD!**

+ To display a success Snackbar:

```Java
Light.success(fab, "Success", Light.LENGTH_SHORT)
        .setAction("Action", new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Do anything you want to do
                Toast.makeText(MainActivity.this, "Hello, Light!", Toast.LENGTH_SHORT).show();
            }
        })
        .show();

// or call

Light.make(fab, "Success", Light.TYPE_SUCCESS, Light.LENGTH_SHORT).show();
```

+ To display an info Snackbar:

```Java
Light.info(fab, "Info", Light.LENGTH_SHORT).show();

// or call
Light.make(fab, "Info", Light.TYPE_INFO, Light.LENGTH_SHORT).show();
```

+ To display a warning Snackbar:

```Java
Light.warning(fab, "Warning", Light.LENGTH_SHORT).show();

// or call
Light.make(fab, "Warning", Light.TYPE_WARNING, Light.LENGTH_SHORT).show();
```

+ To display an error Snackbar:

```java
Light.error(fab, "Error", Light.LENGTH_SHORT).show();

// or call
Light.make(fab, "Error", Light.TYPE_ERROR, Light.LENGTH_SHORT).show();
```

+ To display the usual Snackbar:

```Java
Light.normal(fab, "Normal", Light.LENGTH_SHORT).show();

// or call
Light.make(fab, "Normal", Light.TYPE_NORMAL, Light.LENGTH_SHORT).show();
```

+ You can also create your own Snackbar in custom-designed style:

```Java
Light.make(
        fab, // The view to find a parent from.
        "Awesome Snackbar", // The text to show.
        R.drawable.ic_album_white_24dp, // The left icon of text to show.
        R.color.color_cyan, // The background color of Snackbar.
        android.R.color.white, // The color of text to show.
        Light.LENGTH_INDEFINITE, // How long to display the message.
        R.drawable.ic_done_all_white_24dp, // The left icon of action text.
        R.color.colorAccent) // The color of action text.
        .setAction("Done all", new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Do whatever you want to do.
                Toast.makeText(MainActivity.this, "Hello, Light!", Toast.LENGTH_SHORT).show();
            }
        })
        .show();
```

## Extra

[You can pass formatted text to Light!](./app/src/main/java/io/github/tonnyl/sample/MMainActivity.java/#L68-L78)

## Pull Request

Have some new ideas or find a bug? Do not hesitate to open an `issue` and make a `pull request`.
