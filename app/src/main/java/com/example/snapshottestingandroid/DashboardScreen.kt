package com.example.bankdashboard

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

data class Account(
    val name: String,
    val number: String,
    val balance: String
)

data class Txn(
    val title: String,
    val date: String,
    val amount: String
)

@Composable
fun BankDashboardSimpleScreen(modifier: Modifier = Modifier) {
    val accounts = remember {
        listOf(
            Account("Salary Account", "**** 1129", "AED 54,120.30"),
            Account("Savings", "**** 7781", "AED 72,340.45"),
            Account("Credit Card", "**** 0094", "-AED 1,920.00"),
        )
    }

    val txns = remember {
        listOf(
            Txn("Salary", "22 Dec", "+AED 35,000.00"),
            Txn("Groceries", "21 Dec", "-AED 186.50"),
            Txn("Utilities", "20 Dec", "-AED 420.00"),
            Txn("Food", "19 Dec", "-AED 58.00"),
            Txn("Transfer to Savings", "18 Dec", "-AED 3,000.00"),
        )
    }

    Surface(modifier = modifier.fillMaxSize()) {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            item {
                Text(
                    text = "Hi, Yashwant",
                    style = MaterialTheme.typography.headlineSmall,
                    fontWeight = FontWeight.SemiBold
                )
                Spacer(Modifier.height(4.dp))
                Text(
                    text = "Total Balance",
                    style = MaterialTheme.typography.labelLarge
                )
                Text(
                    text = "AED 128,540.75",
                    style = MaterialTheme.typography.headlineMedium,
                    fontWeight = FontWeight.Bold
                )
            }

            item { SectionTitle("Accounts Summary") }

            items(accounts) { acc ->
                SimpleCard {
                    Column(verticalArrangement = Arrangement.spacedBy(4.dp)) {
                        Text(acc.name, style = MaterialTheme.typography.titleMedium, fontWeight = FontWeight.SemiBold)
                        Text(acc.number, style = MaterialTheme.typography.bodyMedium)
                        Spacer(Modifier.height(6.dp))
                        Text(acc.balance, style = MaterialTheme.typography.titleLarge, fontWeight = FontWeight.Bold)
                    }
                }
            }

            item { SectionTitle("Recent Transactions") }

            items(txns) { tx ->
                SimpleCard {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Column {
                            Text(tx.title, style = MaterialTheme.typography.titleMedium, fontWeight = FontWeight.SemiBold)
                            Text(tx.date, style = MaterialTheme.typography.bodyMedium)
                        }
                        Text(tx.amount, style = MaterialTheme.typography.titleMedium, fontWeight = FontWeight.SemiBold)
                    }
                }
            }
        }
    }
}

@Composable
private fun SectionTitle(text: String) {
    Text(
        text = text,
        style = MaterialTheme.typography.titleLarge,
        fontWeight = FontWeight.Bold,
        modifier = Modifier.padding(top = 8.dp, bottom = 4.dp)
    )
}

@Composable
private fun SimpleCard(content: @Composable () -> Unit) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
        Box(modifier = Modifier.padding(14.dp)) {
            content()
        }
    }
}
