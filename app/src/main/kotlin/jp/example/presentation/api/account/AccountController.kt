package jp.example.presentation.api.account

import jp.example.domain.entities.account.Account
import jp.example.domain.entities.account.AccountCreateParams
import jp.example.domain.repositories.account.AccountRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/account")
class AccountController(
    @Autowired private val accountRepository: AccountRepository
) {

    @GetMapping("{id}")
    fun get(@PathVariable("id") id: Long): Account {
        return accountRepository.selectById(id)!!
    }

    @PostMapping("new")
    fun create() {
        val account = Account.create(
            AccountCreateParams(
                email = "test@test.test",
                password = "",
                name = "test"
            )
        )
        accountRepository.save(account)
    }
}