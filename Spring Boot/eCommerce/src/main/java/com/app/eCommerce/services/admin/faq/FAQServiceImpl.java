package com.app.eCommerce.services.admin.faq;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.app.eCommerce.dto.FAQDto;
import com.app.eCommerce.entity.FAQ;
import com.app.eCommerce.entity.Product;
import com.app.eCommerce.repository.FAQRepository;
import com.app.eCommerce.repository.ProductRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class FAQServiceImpl implements FAQService {

	private final FAQRepository faqRepository;
	
	private final ProductRepository productRepository;
	
	public FAQDto postFAQ(Long productId, FAQDto faqDto) {
		Optional<Product> optionalProduct = productRepository.findById(productId);
		
		if(optionalProduct.isPresent()) {
			FAQ faq = new FAQ();
			
			faq.setQuestion(faqDto.getQuestion());
			faq.setAnswer(faqDto.getAnswer());
			faq.setProduct(optionalProduct.get());
			
			return faqRepository.save(faq).getFAQDto();
		}
		return null;
	}
}

















