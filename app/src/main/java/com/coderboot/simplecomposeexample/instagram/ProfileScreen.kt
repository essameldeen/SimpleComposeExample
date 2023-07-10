package com.coderboot.simplecomposeexample.instagram

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Tab
import androidx.compose.material.TabRow
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.coderboot.simplecomposeexample.R

@Composable
fun ProfileScreen() {
    var selectededTapIndex by remember {
        mutableStateOf(0)
    }

    Column(

        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)


    ) {
        TopBar(name = "Essam Mohamed", modifier = Modifier.padding(10.dp))
        Spacer(modifier = Modifier.height(4.dp))
        ProfileSection()
        Spacer(modifier = Modifier.height(25.dp))

        ButtonSection(modifier = Modifier.fillMaxWidth())
        Spacer(modifier = Modifier.height(25.dp))
        HighLightSection(
            highlight = listOf(
                ImageWithText(
                    image = painterResource(id = R.drawable.youtube),
                    title = "YouTube"
                ),
                ImageWithText(
                    image = painterResource(id = R.drawable.qa),
                    title = "Q&A"
                ),
                ImageWithText(
                    image = painterResource(id = R.drawable.discord),
                    title = "Discord"
                ),
                ImageWithText(
                    image = painterResource(id = R.drawable.telegram),
                    title = "Telegram"
                ),
            ),
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp)
        )
        Spacer(modifier = Modifier.height(10.dp))
        PostTabView(
            imageWithTexts = listOf(
                ImageWithText(
                    image = painterResource(id = R.drawable.ic_grid),
                    title = "Posts"
                ),
                ImageWithText(
                    image = painterResource(id = R.drawable.ic_reels),
                    title = "Reels"
                ),
                ImageWithText(
                    image = painterResource(id = R.drawable.ic_igtv),
                    title = "IGTV"
                ),
                ImageWithText(
                    image = painterResource(id = R.drawable.profile),
                    title = "Profile"
                ),
            )
        ) { tabSelectedIndex ->
            selectededTapIndex = tabSelectedIndex
        }
        when (selectededTapIndex) {
            0 -> PostSection(
                posts = listOf(
                    painterResource(id = R.drawable.kmm),
                    painterResource(id = R.drawable.intermediate_dev),
                    painterResource(id = R.drawable.master_logical_thinking),
                    painterResource(id = R.drawable.bad_habits),
                    painterResource(id = R.drawable.multiple_languages),
                    painterResource(id = R.drawable.learn_coding_fast),
                ),
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
}

@Composable
fun TopBar(
    modifier: Modifier = Modifier,
    name: String,

    ) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceAround,
        modifier = modifier.fillMaxWidth()
    ) {
        Icon(
            imageVector = Icons.Default.ArrowBack,
            contentDescription = "backArrow",
            tint = Color.Black,
            modifier = modifier.size(24.dp)
        )

        Text(
            text = name,
            color = Color.Black,
            style = MaterialTheme.typography.h2,
            overflow = TextOverflow.Ellipsis,

            )
        Icon(
            painter = painterResource(id = R.drawable.ic_bell),
            contentDescription = "bell",
            tint = Color.Black,
            modifier = modifier.size(24.dp)
        )
        Icon(
            painter = painterResource(id = R.drawable.ic_dotmenu),
            contentDescription = "menu",
            tint = Color.Black,
            modifier = modifier.size(20.dp)
        )
    }
}


@Composable
fun ProfileSection(
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier.fillMaxWidth()) {
        Row(
            modifier = modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp)
        ) {
            RoundImage(
                image = painterResource(id = R.drawable.profile),
                modifier = Modifier
                    .size(100.dp)
                    .weight(3f)
            )

            Spacer(modifier = modifier.width(16.dp))
            StateSection(modifier = modifier.weight(7f))
        }
        ProfileDescription(
            "Android Developer",
            description = "6 years of coding experience \n" +
                    "want to make your app ? send me  an Email !",
            url = "Https:youtube.com/c/essamMohamed",
            followedBy = listOf("coddingFlow", "code with nerds"),
            otherCount = 12
        )
    }
}

@Composable
fun RoundImage(
    image: Painter,
    modifier: Modifier = Modifier
) {

    Image(
        painter = image,
        contentDescription = null,
        modifier = modifier
            .aspectRatio(1f, matchHeightConstraintsFirst = true)
            .border(width = 1.dp, color = Color.LightGray, shape = CircleShape)
            .padding(3.dp)
            .clip(
                CircleShape
            )
    )
}

@Composable
fun StateSection(modifier: Modifier = Modifier) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceAround,
        modifier = modifier
    ) {

        ProfileState(numberText = "601", text = "Posts")
        ProfileState(numberText = "99.8K", text = "Followers")
        ProfileState(numberText = "450", text = "Following")


    }
}

@Composable
fun ProfileState(
    numberText: String,
    modifier: Modifier = Modifier,
    text: String
) {

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = modifier
    ) {

        Text(text = numberText, fontWeight = FontWeight.Bold, fontSize = 20.sp, color = Color.Black)
        Spacer(modifier = Modifier.height(4.dp))
        Text(text = text, fontWeight = FontWeight.Bold, color = Color.Black)

    }
}

@Composable
fun ProfileDescription(
    displayName: String,
    description: String,
    url: String,
    followedBy: List<String>,
    otherCount: Int
) {
    val litterSpacing = 0.5.sp
    val lineHeight = 20.sp

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp)
    ) {

        Text(
            text = displayName, fontWeight = FontWeight.Bold, letterSpacing = litterSpacing,
            lineHeight = lineHeight,
            color = Color.Black
        )
        Text(
            text = description,
            letterSpacing = litterSpacing,
            lineHeight = lineHeight,
            color = Color.Black

        )
        Text(
            text = url, color = Color(0xff3d3d91),
            letterSpacing = litterSpacing,
            lineHeight = lineHeight,

            )

        if (followedBy.isNotEmpty()) {
            Text(
                text = buildAnnotatedString {
                    val boldStyle = SpanStyle(
                        color = Color.Black,
                        fontWeight = FontWeight.Bold
                    )
                    append("Followed By ")

                    followedBy.forEachIndexed { index, name ->
                        pushStyle(boldStyle)
                        append(name)
                        pop()
                        if (index < followedBy.size - 1) {
                            append(", ")
                        }

                    }
                    if (otherCount > 2) {
                        append(" and  ")
                        pushStyle(boldStyle)
                        append("$otherCount others")
                    }

                },
                letterSpacing = litterSpacing,
                lineHeight = lineHeight

            )
        }


    }
}


@Composable
fun ButtonSection(
    modifier: Modifier = Modifier
) {
    val minWidth = 95.dp
    val height = 30.dp
    Row(
        horizontalArrangement = Arrangement.SpaceEvenly,
        modifier = modifier
    ) {
        ActionButton(
            title = "Following",
            icon = Icons.Default.KeyboardArrowDown,
            modifier = Modifier
                .defaultMinSize(minWidth = minWidth)
                .height(height)
        )
        ActionButton(
            title = "Message",
            modifier = Modifier
                .defaultMinSize(minWidth = minWidth)
                .height(height)
        )
        ActionButton(
            title = "Email",
            modifier = Modifier
                .defaultMinSize(minWidth = minWidth)
                .height(height)
        )
        ActionButton(
            icon = Icons.Default.KeyboardArrowDown,
            modifier = Modifier
                .size(height)
        )
    }
}

@Composable
fun ActionButton(
    modifier: Modifier = Modifier,
    title: String? = null,
    icon: ImageVector? = null
) {

    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center,
        modifier =
        modifier
            .border(width = 1.dp, color = Color.LightGray, shape = RoundedCornerShape(5.dp))
            .padding(6.dp)
    ) {

        if (title != null) {
            Text(text = title, fontWeight = FontWeight.SemiBold, fontSize = 14.sp)
        }
        if (icon != null) {
            Icon(imageVector = icon, contentDescription = null, tint = Color.Black)
        }
    }
}


@Composable
fun HighLightSection(
    modifier: Modifier = Modifier,
    highlight: List<ImageWithText>
) {
    LazyRow(modifier = modifier) {
        items(highlight.size) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
                modifier = Modifier.padding(end = 15.dp)
            ) {

                RoundImage(
                    image = highlight[it].image,
                    modifier = Modifier.size(70.dp)
                )
                Text(
                    text = highlight[it].title,
                    overflow = TextOverflow.Ellipsis,
                    textAlign = TextAlign.Center
                )


            }
        }
    }
}

@Composable
fun PostTabView(
    modifier: Modifier = Modifier,
    imageWithTexts: List<ImageWithText>,
    onTapSelected: (selectedIndex: Int) -> Unit,
) {
    var selectedTapIndex by remember {
        mutableStateOf(0)
    }
    val inActiveColor = Color(0xff777777)
    TabRow(
        selectedTabIndex = selectedTapIndex,
        backgroundColor = Color.Transparent,
        contentColor = Color.Black,
        modifier = modifier

    ) {

        imageWithTexts.forEachIndexed { index, item ->

            Tab(
                selected = selectedTapIndex == index,
                selectedContentColor = Color.Black,
                unselectedContentColor = inActiveColor,
                onClick = {
                    selectedTapIndex = index
                    onTapSelected(selectedTapIndex)
                }) {

                Icon(
                    painter = item.image, contentDescription = item.title,
                    tint = if (selectedTapIndex == index) Color.Black else inActiveColor,
                    modifier = Modifier
                        .padding(10.dp)
                        .size(20.dp)
                )
            }

        }


    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun PostSection(
    posts: List<Painter>,
    modifier: Modifier = Modifier
) {
    LazyVerticalGrid(
        cells = GridCells.Fixed(3),
        modifier = modifier.scale(1.01f)
    ) {
        items(posts.size) {
            Image(
                painter = posts[it],
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .aspectRatio(1f)
                    .border(
                        width = 1.dp,
                        color = Color.White,


                        )
            )
        }
    }
}